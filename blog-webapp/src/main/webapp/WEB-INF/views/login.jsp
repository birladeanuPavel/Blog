<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<jsp:include page="template/header.jsp"/>

<form method="post" class="form-horizontal">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

    <div class="form-group">
        <label class="col-sm-2 control-label" for="nickname">Nume utilizator</label>

        <div class="col-sm-10">
            <input type="text" id="nickname" name="nickname"/>
        </div>
    </div>
    <div class="form-group">
        <label class="col-sm-2 control-label" for="password">Parola</label>

        <div class="col-sm-10">
            <input type="password" id="password" name="password"/>
        </div>
    </div>

    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" class="btn btn-primary">Log in</button>
        </div>
    </div>
</form>

<jsp:include page="template/footer.jsp"/>
