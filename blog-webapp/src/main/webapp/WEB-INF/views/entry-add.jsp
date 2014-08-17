<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<jsp:include page="template/header.jsp"/>
<h1>Adauga inregistrare</h1>

<form:form modelAttribute="entry" method="post" cssClass="form-horizontal">
    <div class="form-group">
        <label class="col-sm-2 control-label">Titlu<span class="required">*</span></label>

        <div class="col-sm-10">
            <form:input path="title" cssClass="form-control"/>
            <form:errors path="title" cssClass="text-danger"/>
        </div>
    </div>

    <div class="form-group">
        <label class="col-sm-2 control-label">Continut</label>

        <div class="col-sm-10">
            <form:textarea path="content" cssClass="form-control"/>
        </div>
    </div>

    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" class="btn btn-primary">Adauga inregistrare</button>
            <button type="reset" class="btn btn-default">Resetare campuri</button>
        </div>
    </div>
</form:form>

<jsp:include page="template/footer.jsp"/>
