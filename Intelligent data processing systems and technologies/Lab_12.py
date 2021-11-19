import numpy as np
import pandas as pd
import matplotlib.pyplot as plt
import seaborn as sns
sns.set()

from sklearn.metrics import r2_score, median_absolute_error, mean_absolute_error
from sklearn.metrics import median_absolute_error, mean_squared_error, mean_squared_log_error

from scipy.optimize import minimize
import statsmodels.tsa.api as smt
import statsmodels.api as sm

# tqdm - это модуль Python, который легко выводит на консоль динамически обновляемый индикатор выполнения.
from tqdm import tqdm_notebook

from itertools import product

# определяем среднюю среднюю процентную ошибку (MAPE) , так как это будет наша метрика ошибки

def mean_absolute_percentage_error(y_true, y_pred):
    return np.mean(np.abs((y_true - y_pred) / y_true)) * 100

import warnings
warnings.filterwarnings('ignore')





df = pd.read_csv("CSV/Electric_Production.csv",index_col=['DATE'], parse_dates=['DATE'])

# drop_cols = ['Adj Close',  'Volume']
#drop_cols = [ 'Volume']
# df.drop(drop_cols, axis=1, inplace=True)
print(df.head())
#1
plt.figure(figsize=(17, 8))
plt.plot(df.IPG2211A2N)
plt.title('electricity production per month')
plt.ylabel('Electricity production')
plt.xlabel('Date')
plt.grid(False)
plt.show()

def plot_moving_average(series, window, plot_intervals=False, scale=1.96):
    rolling_mean = series.rolling(window=window).mean()

    plt.figure(figsize=(17, 8))
    plt.title('Moving average\n window size = {}'.format(window))
    plt.plot(rolling_mean, 'g', label='Rolling mean trend')

    # Plot confidence intervals for smoothed values
    if plot_intervals:
        mae = mean_absolute_error(series[window:], rolling_mean[window:])
        deviation = np.std(series[window:] - rolling_mean[window:])
        lower_bound = rolling_mean - (mae + scale * deviation)
        upper_bound = rolling_mean + (mae + scale * deviation)
        plt.plot(upper_bound, 'r--', label='Upper bound / Lower bound')
        plt.plot(lower_bound, 'r--')

    plt.plot(series[window:], label='Actual values')
    plt.legend(loc='best')
    plt.grid(True)
    plt.show()
#2
plot_moving_average(df.IPG2211A2N, 12, plot_intervals=True)



def tsplot(y, lags=None, figsize=(12, 7), syle='bmh'):
    if not isinstance(y, pd.Series):
        y = pd.Series(y)

    with plt.style.context(style='bmh'):
        fig = plt.figure(figsize=figsize)
        layout = (2, 2)
        ts_ax = plt.subplot2grid(layout, (0, 0), colspan=2)
        acf_ax = plt.subplot2grid(layout, (1, 0))
        pacf_ax = plt.subplot2grid(layout, (1, 1))

        y.plot(ax=ts_ax)
        p_value = sm.tsa.stattools.adfuller(y)[1]
        ts_ax.set_title('Time Series Analysis Plots\n Dickey-Fuller: p={0:.5f}'.format(p_value))
        smt.graphics.plot_acf(y, lags=lags, ax=acf_ax)
        smt.graphics.plot_pacf(y, lags=lags, ax=pacf_ax)
        plt.tight_layout()
        plt.show()

#3
tsplot(df.IPG2211A2N, lags=12)


df_diff = df.IPG2211A2N - df.IPG2211A2N.shift(1)
#4
tsplot(df_diff[1:], lags=12)



# Установите начальные значения и некоторые границыs
ps = range(0, 2)
d = 1
qs = range(0, 2)
Ps = range(0, 2)
D = 1
Qs = range(0, 2)
s = 3

# Составьте список со всеми возможными комбинациями параметров
parameters = product(ps, qs, Ps, Qs)
parameters_list = list(parameters)
len(parameters_list)


def optimize_SARIMA(parameters_list, d, D, s):
    """
        Return dataframe with parameters and corresponding AIC

        parameters_list - list with (p, q, P, Q) tuples
        d - integration order
        D - seasonal integration order
        s - length of season
    """

    results = []
    best_aic = float('inf')

    for param in tqdm_notebook(parameters_list):
        try:
            model = sm.tsa.statespace.SARIMAX(df.IPG2211A2N, order=(param[0], d, param[1]),
                                              seasonal_order=(param[2], D, param[3], s)).fit(disp=-1)
        except:
            continue

        aic = model.aic

        # Save best model, AIC and parameters
        if aic < best_aic:
            best_model = model
            best_aic = aic
            best_param = param
        results.append([param, model.aic])

    result_table = pd.DataFrame(results)
    result_table.columns = ['parameters', 'aic']
    # Sort in ascending order, lower AIC is better
    result_table = result_table.sort_values(by='aic', ascending=True).reset_index(drop=True)

    return result_table


result_table = optimize_SARIMA(parameters_list, d, D, s)




# Set parameters that give the lowest AIC (Akaike Information Criteria)

p, q, P, Q = result_table.parameters[0]

best_model = sm.tsa.statespace.SARIMAX(df.IPG2211A2N, order=(p, d, q),
                                       seasonal_order=(P, D, Q, s)).fit(disp=-1)

# печатаем краткие характеристики лучшей модели
print(best_model.summary())


print(best_model.predict(start=df.IPG2211A2N.shape[0], end=df.IPG2211A2N.shape[0] + 5))
print("MAPE=",mean_absolute_percentage_error(df.IPG2211A2N[s + d:], best_model.fittedvalues[s + d:]))

actualData = pd.read_csv("CSV/Actual.csv",index_col=['DATE'], parse_dates=['DATE'])
predictedData = (best_model.predict(start=df.IPG2211A2N.shape[0], end=df.IPG2211A2N.shape[0] + 5)).to_frame()

comparison = pd.DataFrame({'actual': actualData.IPG2211A2N,
                          'predicted':predictedData.predicted_mean})
print(comparison)


plt.figure(figsize=(17, 8))
plt.plot(comparison.actual, label='actual value')
plt.plot(comparison.predicted, label='predicted value')
plt.title('electricity production per month')
plt.ylabel('Electricity production')
plt.xlabel('Date')
plt.legend()
plt.grid(False)
plt.show()