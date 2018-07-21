#!/bin/bash

echo "开始运行"
mvn clean package

echo "Exam2程序运行结果："
java -jar ./Exam3/target/Exam2.jar
