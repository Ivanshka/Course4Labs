import pandas as pd
from sklearn.model_selection import *
from sklearn. svm import *
from sklearn.metrics import *
from prettytable import PrettyTable

df=pd.read_csv("CSV/wine.csv")
df["quality"]=df["quality"].map({"good": 1, "bad": 0})
print(df.head())
X = df.drop('quality',axis=1)
print(X.head())
y = df.quality # Target variable
print(y.head())
X_train,X_test,y_train,y_test=train_test_split(X,y,test_size=0.25,random_state=0)

# создаём линейное ядро
linearSVCClassifier = SVC(kernel='linear')
#обучаем
linearSVCClassifier.fit(X_train, y_train)
# делаем прогнозы
y_pred = linearSVCClassifier.predict(X_test)
print(linearSVCClassifier.score(X_train,y_train))
# выводим точность
linearSVCClassifier_confusion_matrix=confusion_matrix(y_test,y_pred)
# выводим матрицу сопряжённости
print(linearSVCClassifier_confusion_matrix)
# выводим различные показатели данной модели
print(classification_report(y_test,y_pred))
# полиномиальное ядро, степень 3
polynomialSVCClassifier = SVC(kernel='poly', degree=3)
polynomialSVCClassifier.fit(X_train, y_train)
y_pred = polynomialSVCClassifier.predict(X_test)
print(polynomialSVCClassifier.score(X_train,y_train))
polynomialSVCClassifier_confusion_matrix=confusion_matrix(y_test,y_pred)
print(polynomialSVCClassifier_confusion_matrix)
print(classification_report(y_test, y_pred))

# RBF ядро( Гаусса)
RBF_SVC_Cassifier = SVC(kernel='rbf')
RBF_SVC_Cassifier.fit(X_train, y_train)
y_pred = RBF_SVC_Cassifier.predict(X_test)
RBF_SVC_Cassifier_confusion_matrix=confusion_matrix(y_test, y_pred)
print(RBF_SVC_Cassifier.score(X_train,y_train))
print(RBF_SVC_Cassifier_confusion_matrix)
print(classification_report(y_test, y_pred))

# делаем вывод даннных в таблицу
x = PrettyTable()
x.field_names = ["Линейное ядро", "Полиномиальное ядро 3 степени", "RBF ядро" ]
x.add_row([linearSVCClassifier.score(X_train,y_train), polynomialSVCClassifier.score(X_train,y_train),RBF_SVC_Cassifier.score(X_train,y_train)])
x.add_row([linearSVCClassifier_confusion_matrix,polynomialSVCClassifier_confusion_matrix,RBF_SVC_Cassifier_confusion_matrix])
print(x)