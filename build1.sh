#!/bin/bash

echo "开始运行"
mvn clean package

echo "Exam1程序运行结果："
java -jar ./Exam1/target/Exam1.jar
