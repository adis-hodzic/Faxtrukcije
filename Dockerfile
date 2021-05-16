FROM postgres
ENV POSTGRES_PASSWORD=1234
COPY ./scripts /docker-entrypoint-initdb.d/