<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <script src="https://cdn.tailwindcss.com"></script>
  <title>App Zoo</title>
</head>
<body>
  <header>
    <h1 class="text-4xl">App Zoo</h1>
  </header>
  <main>
    <table class="mx-auto"> 
      <thead>
        <tr>
          <th>Campo</th>
          <th>Tipo</th>
          <th>Obs</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td>id</td>
          <td>int</td>
          <td>Chave primária</td>
        </tr>
        <tr>
          <td>nome</td>
          <td>varchar(255)</td>
          <td>Nome do animal</td>
        </tr>
        <tr>
          <td>especie</td>
          <td>varchar(255)</td>
          <td>Espécie do animal</td>
        </tr>
      </tbody>
    </table>
  </main>
</body>
</html>
