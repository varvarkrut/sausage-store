#! /bin/bash
#Если свалится одна из команд, рухнет и весь скрипт
set -xe
#Перезаливаем дескриптор сервиса на ВМ для деплоя
sudo cp -rf sausage-store-frontend.service /etc/systemd/system/sausage-store-frontend.service
sudo rm -r /var/www-data/dist/frontend||true
#Переносим артефакт в нужную папку

curl -u ${NEXUS_REPO_USER}:${NEXUS_REPO_PASS} -o frontend.tar.gz ${NEXUS_REPO_URL}/10-sausage-store-shkurko-ivan-frontend/sausage-store/${VERSION}/sausage-store-${VERSION}.tar.gz
tar -xf frontend.tar.gz
sudo cp -r ./frontend /var/www-data/dist/frontend||true  #true говорит, если команда обвалится — продолжай
#Обновляем конфиг systemd с помощью рестарта
sudo systemctl daemon-reload
#Перезапускаем сервис сосисочной
sudo systemctl restart sausage-store-frontend