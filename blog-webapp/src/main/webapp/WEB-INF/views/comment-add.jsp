<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<jsp:include page="template/header.jsp"/>
<h1>Adauga comentariu</h1>

<form:form modelAttribute="comment" method="post" cssClass="form-horizontal">
    <div class="form-group">
        <label class="col-sm-2 control-label">Comentariu<span class="required">*</span></label>

        <div class="col-sm-10">
            <form:textarea rows="5" path="content" cssClass="form-control"/>
            <form:errors path="content" cssClass="text-danger"/>
        </div>
    </div>

    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" class="btn btn-primary">Adauga comentariu</button>
        </div>
    </div>
</form:form>

<jsp:include page="template/footer.jsp"/>
