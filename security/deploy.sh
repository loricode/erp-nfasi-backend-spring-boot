#!/bin/bash

echo "Compilando proyecto..."
mvn clean package || { echo "Error en Maven"; exit 1; }

echo "Eliminando contenedor antiguo..."
docker rm -f erp-security-container 2>/dev/null || true

echo "Construyendo imagen Docker..."
docker build -t erp-security . || { echo "Error al construir imagen"; exit 1; }

echo "Ejecutando contenedor..."
docker run -d -p 8081:8081 --name erp-security-container erp-security
echo "¡Listo! Contenedor erp-security-container ejecutándose en el puerto 8081"