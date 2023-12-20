FROM mongo:6

EXPOSE 27017

COPY start-mongodb.sh /docker-entrypoint-initdb.d/

CMD ["mongod", "--bind_ip_all"]
