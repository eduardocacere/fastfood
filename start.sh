#!/bin/bash

echo "Iniciando Applicação"
echo " "
echo "Gerando pacote da applicação"
  sleep 5
  ./mvnw clean package

echo " "
echo "Fazendp build da imagem"
  sleep 5
  docker build -t fastfood:lasted .

echo " "
echo "Subindo Serviços e dependencias"
  sleep 5
  docker-compose -f docker-compose.yml up -d

echo " "
echo " ****** Aplicação esta rodando ******"
echo " "

