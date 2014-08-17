<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:include page="template/header.jsp"/>

<c:forEach items="${entries}" var="entry" varStatus="status">
    <div class="blog-post">
        <h2 class="blog-post-title"><a href="/blog/entry/${entry.id}">${entry.title}</a></h2>

        <div class="blog-post-meta">
            <div class="clearfix">
                <div class="pull-left text-info">${entry.date}</div>
                <sec:authorize access="hasAnyRole('ROLE_ADMIN')">
                    <div class="pull-right">
                        <a href="/blog/entry/${entry.id}/delete" class="btn btn-danger btn-xs">Sterge</a>
                    </div>
                </sec:authorize>
            </div>

        </div>
        <div class="blog-post-content">
                ${entry.content}
        </div>
    </div>
</c:forEach>

<jsp:include page="template/footer.jsp"/>
