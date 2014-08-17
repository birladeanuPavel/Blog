<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Blog</title>
    <link href="/css/bootstrap.min.css" rel="stylesheet" media="screen">
    <link href="/css/bootstrap-theme.min.css" rel="stylesheet" media="screen">

    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>

<nav class="navbar navbar-default navbar-inverse" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="/blog">Blog</a>
        </div>

        <sec:authorize access="hasRole('ROLE_ADMIN')">
            <ul class="nav navbar-nav">
                <li><a href="/blog/entry/add">Adauga inregistrare</a></li>
            </ul>
        </sec:authorize>

        <ul class="nav navbar-nav navbar-right">
            <sec:authorize access="isAnonymous()">
                <li><a href="/blog/login">Login</a></li>
            </sec:authorize>
            <sec:authorize access="isAuthenticated()">
                <li><a href="/blog/logout">Logout</a></li>
            </sec:authorize>
        </ul>

        <form class="navbar-form navbar-right" role="search" method="POST" action="/blog/search">
            <div class="form-group">
                <input type="text" name="query" class="form-control" placeholder="Search">
            </div>
            <button type="submit" class="btn btn-default">Cauta</button>
        </form>
    </div>
</nav>
<div class="container">
    <div class="row">
        <div class="col-sm-8 blog-main">