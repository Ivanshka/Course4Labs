import numpy as np
import matplotlib.pyplot as plt
import pandas as pd

"""
""1.numpy
"""
firstArray=np.array([[3,6,3],[3,6,3]])
print(firstArray)
secondArray=np.array([[6,5,1],[4,9,5]])
print(secondArray)

print(f"Sum of 2 arrays \n{firstArray+secondArray}")
print(f"Subtraction of 2 arrays \n{firstArray-secondArray}")
print(f"Multiplication of 2 arrays \n{firstArray*secondArray}")
print(f"Division of 2 arrays \n {firstArray/secondArray}")

randomArray=np.random.randint(0, 77, 20)
print(randomArray)
randomArray=np.reshape(randomArray, (4, 5))
print(randomArray)
randomArray=np.split(randomArray, len(randomArray) / 2)
print(randomArray)


inputValue = int(input("Enter number which you want to find in array(for example:6):"))
countOfEqualNumbers=0
for i in range(len(firstArray)):
    for j in range(len(firstArray[i])):
        if(firstArray[i][j]==inputValue):
            print("The value of number is equal 6 ")
            countOfEqualNumbers=countOfEqualNumbers+1
print("Total count of equal numbers is:",countOfEqualNumbers)


print("Min value in a second array is:",secondArray.min())
print("Max value in a second array is:",secondArray.max())
print("Avg value in a second array is:",secondArray.mean())
"""
""2.pandas
"""

seriesFromArray=pd.Series(np.array([5,5,5,3]))
firstSeriesFromDictionary=pd.Series({i: np.random.randint(10) for i in 'abcdefghij'})
secondSeriesFromDictionary=pd.Series({i: np.random.randint(10) for i in 'abcdefghij'})
print(seriesFromArray)
print(firstSeriesFromDictionary)

print(f"Sum of 2 series  {secondSeriesFromDictionary+firstSeriesFromDictionary}")
print(f"Subtraction of 2 series  {secondSeriesFromDictionary-firstSeriesFromDictionary}")
print(f"Multiplication of 2 series  {secondSeriesFromDictionary*firstSeriesFromDictionary}")
print(f"Division of 2 series  {secondSeriesFromDictionary/firstSeriesFromDictionary}")


df = pd.DataFrame(np.random.rand(3, 2),
                  columns=['foo', 'bar'],
                  index=['a', 'b', 'c'])
print("DataFrame created from Numpy array is:",df)

df = pd.DataFrame([{'a': 1, 'b': 2}, {'b': 3, 'c': 4}])
print("DataFrame created from dictionary array is:",df)

population_dict = {'California': 38332521,
                   'Texas': 26448193,
                   'New York': 19651127,
                   'Florida': 19552860,
                   'Illinois': 12882135}
population = pd.Series(population_dict)
df = pd.DataFrame(population, columns=['population'])
print("DataFrame created from Series  is \n:",df)

print("//////////////////////")
d = {"price":np.array([1, 2, 3]),
    "count": np.array([10, 20, 30])}
dataFrame= pd.DataFrame(d, index=['a', 'b', 'c'])

print("Data frame:",dataFrame)

print("find by column")
print(dataFrame['count'])
print("find by label")
print(dataFrame.loc['a'])
print("find by index")
print(dataFrame.iloc[1])

print(dataFrame[0:2])
print( dataFrame[dataFrame['count'] >= 20])

"""
""3.matplotlib
"""

Xt=[14,16,17,19,18,15,14,18,17,15,13,16,17,19,18,20,12,13,12,14]
Yt=[222,241,243,285,253,247,246,276,261,254,229,249,252,279,262,275,211,220,218,232]
print(Xt)
print(Yt)
plt.scatter(Xt,Yt, label='s',color='k',marker='x',s=100)
plt.xlabel('Xt')
plt.ylabel('Yt')
plt.title("LOL")

plt.axis([12, 20, 200, 300])
plt.show()