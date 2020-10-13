<%--
  Created by IntelliJ IDEA.
  User: Олег
  Date: 12.03.2020
  Time: 19:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<main>
    <div class="container">
        <div class="row">
            <div class="col-md-2"></div>
            <div class="col-md-8">
                <div class="alert alert-info" role="alert">Добро пожаловать, ${userName}</div>
                <div class="flex-container">
                    <div class="flex-item1">
                        <a href="/students" class="btn btn-outline-info" role="button"
                           aria-pressed="true">Студенты</a>
                    </div>
                    <div class="flex-item2">
                        <a href="/disciplines" class="btn btn-outline-info" role="button"
                           aria-pressed="true">Дисциплины</a>
                    </div>
                    <div class="flex-item3">
                        <a href="/termsList" class="btn btn-outline-info" role="button"
                           aria-pressed="true">Семестры</a>
                    </div>
                </div>
            </div>
            <div class="col-md-2"></div>
        </div>
    </div>
</main>
