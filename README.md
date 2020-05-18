# OFFICE API
##### API SIMPLES PARA TESTES
##### [Link do deploy no Heroku](https://mc-office-api.herokuapp.com/) 

---

#### Cadastro de usuários com as seguintes informações:

---
> id 
>
> Nome (name)
>
> Idade (age)
>
> Escritório (office - cargo ou empresa)
---

#### ENDPOINTS:
##### /list
- Lista todos os usuários

##### /user/{id}
- Lista o usuário que contenha o mesmo valor de ID

##### /create
- Cria um novo usuário, necessita das seguintes informações:

> Nome (name)
>
> Idade (age)
>
> Escritório (office - cargo ou empresa)

##### /update/{id}
- Atualiza um usuário que contenha o mesmo valor de ID

##### /delete/{id}
- Deleta um usuário que contenha o mesmo valor de ID

##### /refresh
- Limpa o banco de dados e traz 4 registros padrão
