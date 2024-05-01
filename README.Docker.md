### Construindo e executando sua aplicação

Quando estiver pronto, inicie sua aplicação executando:
`docker compose up --build`.

Sua aplicação estará disponível em http://localhost:8080.

### Implantando sua aplicação na nuvem

Primeiro, construa sua imagem, por exemplo: `docker build -t myapp .`.
Se a nuvem que você está usando tiver uma arquitetura de CPU diferente da sua
máquina de desenvolvimento (por exemplo, você está em um Mac M1 e seu provedor de nuvem é amd64),
você vai querer construir a imagem para essa plataforma, por exemplo:
`docker build --platform=linux/amd64 -t myapp .`.

Em seguida, envie-a para seu registro, por exemplo `docker push myregistry.com/myapp`.

Consulte os [guias de iniciação](https://docs.docker.com/go/get-started-sharing/)
da Docker para obter mais detalhes sobre como construir e enviar imagens.