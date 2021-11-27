import  pandas as pd
import seaborn as sns
import matplotlib.pyplot  as plt
from sklearn.linear_model import *

# медицинское страхование
df=pd.read_csv("CSV/insurance.csv")
df.drop(df.columns[5], axis=1, inplace=True)
df.drop(df.columns[4], axis=1, inplace=True)
df.drop(df.columns[1], axis=1, inplace=True)
print(df.head())

sns.heatmap(df.corr(), annot = True, fmt='.1g')
plt.show()

sns.pairplot(df)
plt.show()

# количество детей
X = df[['bmi']].values
# сборы
y = df['charges'].values

model=LinearRegression().fit(X, y)
# y= ax +b , b=model.coef[0],a=model.intercept
print('Slope: {:.2f}'.format(model.coef_[0]))
print('Intercept: {:.2f}'.format(model.intercept_))
print('coefficient of determination:',model.score(X, y))

sns.regplot(x="bmi", y="charges", data=df)
plt.show()

# дети, возраст, индекс массы тела
_X = df[['children','age','bmi']].values
# сборы
_y = df['charges'].values
model=LinearRegression().fit(_X, _y)
print('Slope1: {:.2f}'.format(model.coef_[0]))
print('Slope2: {:.2f}'.format(model.coef_[1]))
print('Intercept: {:.2f}'.format(model.intercept_))
print('coefficient of determination:',model.score(_X, _y))
