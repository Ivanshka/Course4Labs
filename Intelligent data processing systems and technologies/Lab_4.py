import matplotlib.pyplot as plt
import  pandas as pd
import seaborn as sns

dataFrame=pd.read_csv('trees.csv', delimiter=',')
print(dataFrame)
colours = ['#eeeeee' , '#ff0000']
sns.heatmap(dataFrame.isnull(), cmap=sns.color_palette(colours))
plt.show()
#info
print(dataFrame.info())
print(dataFrame.isnull().sum())
print(dataFrame.isnull())
#excluding values
newDataFrame = dataFrame.drop(columns=dataFrame.columns[dataFrame.isna().sum(axis=0) == dataFrame.isna().sum(axis=0).max()])
newDataFrame = dataFrame.drop(index=dataFrame.index[dataFrame.isna().sum(axis=1) == dataFrame.isna().sum(axis=1).max()])
print(newDataFrame)
#filleng NAN values
newDataFrameAVG=newDataFrame.fillna(newDataFrame.mean())
print("AVG")
print(newDataFrameAVG)
newDataFrameModa=newDataFrame.fillna(newDataFrame['Girth'].mode()[0])
print("MODA")
print(newDataFrameModa)
newDataFrameFFill=newDataFrame.fillna(method="ffill")
print("Previous value")
print(newDataFrameFFill)

h0 = dataFrame['Girth'].hist()
fig0 = h0.get_figure()
plt.show()
h1 = newDataFrameAVG['Girth'].hist()
fig1 = h1.get_figure()
plt.show()
h2= newDataFrameModa['Girth'].hist()
fig2 = h2.get_figure()
plt.show()
h3 = newDataFrameFFill['Girth'].hist()
fig3 = h3.get_figure()
plt.show()
