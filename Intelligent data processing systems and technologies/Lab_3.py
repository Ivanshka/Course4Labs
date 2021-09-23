import matplotlib.pyplot as plt
import seaborn as sns
import pandas as pd
import warnings
warnings.simplefilter(action='ignore', category=FutureWarning)

Data=pd.read_csv('browser-ww-monthly-202008-202108.csv', delimiter=',')

print(Data)

newData=Data['Firefox']
newData[3]=10
print(newData)

sns_plot = sns.histplot(newData)
fig = sns_plot.get_figure()
plt.axvline(newData.mean())
plt.axvline(newData.median())
plt.show()

print("AVG:",newData.mean())
print("Median:",newData.median())


plt.boxplot(newData)
plt.show()

print("AVG:",Data.mean())
print("Median:",Data.median())


print("Describe",Data.describe())