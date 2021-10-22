import numpy as np
import  pandas as pd
from sklearn.tree import *
from sklearn.model_selection import *
from sklearn.neighbors import *
import sys
import warnings
import time
from sklearn.metrics import *
import matplotlib.pyplot as plt
import seaborn as sns
from sklearn import tree

if not sys.warnoptions:
    warnings.simplefilter("ignore")
df=pd.read_csv("CSV/wine.csv")
print(df)
#df.drop(["State", "Voice mail plan"], axis=1, inplace=True)
df["quality"]=df["quality"].map({"good": 1, "bad": 0})
print(df.head())
print(df.info())

# формируем ветор меток y
y=df["quality"].astype("int")
# формируем массив данных x
x=df.drop("quality",axis=1)
# проверяем размерность
print(x.shape)
print(y.shape)
x_train, x_valid, y_train, y_valid = train_test_split(x, y, test_size=0.3, random_state=11)
print(f"x_train_shape:{x_train.shape}####### x_valid_shape:{x_valid.shape}")
print(f"y_train_shape:{y_train.shape}####### y_valid_shape:{y_valid.shape}")
# при помощи дерева решений
first_tree = DecisionTreeClassifier(random_state=11)
# оценка модели с помощью кросс-валидации
# работает cross_val_score следующим образом,
# а именно, что в она разбивает X и y на 4 части,
# обучает модель на 3/4 части и проверяет ее на 1/4 части при cv=4
print(cross_val_score(first_tree, x_train, y_train, cv=11))
#среднее по пяти оценкам
print("DT:",np.mean(cross_val_score(first_tree, x_train, y_train, cv=11)))

# метод к ближайших соседей
first_knn = KNeighborsClassifier()
print("Knn:",np.mean(cross_val_score(first_knn, x_train, y_train, cv=11)))
# улучшаем метод DT
tree_params = {"max_depth": np.arange(1, 11), "max_features": [0.5, 0.7, 1]}
tree_grid = GridSearchCV(first_tree, tree_params, cv=11, n_jobs=-1)

st=time.time()
print(tree_grid.fit(x_train, y_train))
print("----%.2f----"%(time.time()-st))
print(tree_grid.best_score_, tree_grid.best_params_)
# улучшаем метод KNN
knn_params = {"n_neighbors": range(5, 30, 5)}
knn_grid = GridSearchCV(first_knn, knn_params, cv=11)
st=time.time()
print(knn_grid.fit(x_train, y_train))
print("----%.2f----"%(time.time()-st))
print(knn_grid.best_score_, knn_grid.best_params_)


print(tree_grid.best_estimator_)
tree_valid_pred = tree_grid.predict(x_valid) # прогноз на отложенной выборке
print(tree_valid_pred[0:20]) # первые 20 спрогнозированых меток
print(accuracy_score(y_valid, tree_valid_pred))
print(confusion_matrix(y_valid, tree_valid_pred))

# выводим дерево решений в dot файл
first_tree.fit(x_train,y_train)
tree.export_graphviz(first_tree, out_file='tree.dot', feature_names=x_train.columns)

# здесь выводится различные графики по датасету,
# работает ОЧЕНЬ медленно,
sns.pairplot(df, hue="quality", palette="icefire")
plt.show()
# выводим график доли ошибок при разном количестве соседей
error = []
for i in range(1, 40):
    knn = KNeighborsClassifier(n_neighbors=i)
    knn.fit(x_train, y_train)
    pred_i = knn.predict(x_valid)
    error.append(np.mean(pred_i != y_valid))
plt.figure(figsize=(12, 6))
plt.plot(range(1, 40), error, color='red', linestyle='dashed', marker='o',
         markerfacecolor='blue', markersize=10)
plt.title('Error Rate K Value')
plt.xlabel('K Value')
plt.ylabel('Mean Error')
plt.show()