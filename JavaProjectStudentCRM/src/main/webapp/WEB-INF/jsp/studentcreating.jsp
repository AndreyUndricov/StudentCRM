<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<main>
    <div class="row">
        <div class="col-sm-2">
            <nav>
                <div id="divNav" class="row">
                    <a id="home" href="/" class="btn btn-outline-secondary btn-sm">На главную</a>
                    <a id="back" href="/students" class="btn btn-outline-secondary btn-sm">Назад</a>
                </div>
            </nav>
        </div>
        <div class="col-md-8">
            <main-content>
                <h3>Для создания студента заполните все поля и нажмите кнопку "Создать"</h3>
                <div class="student-form">
                    <form action="/createStudent" method="post">
                        <div class="form-group row">
                            <label for="LastName" class="col-sm-3 col-form-label">Фамилия</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" id="LastName" placeholder="Иванов"
                                       name="lastName">
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="FirstName" class="col-sm-3 col-form-label">Имя</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" id="FirstName" placeholder="Иван"
                                       name="firstName">
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="Group" class="col-sm-3 col-form-label">Группа</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" id="Group" placeholder="ЭИ-302"
                                       name="group">
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="datepicker" class="col-sm-4 col-form-label">Дата зачисления</label>
                            <div class="col-sm-8">
                                <c:set var="now" value="<%= new java.util.Date() %>"/>
                                <input type="text" class="form-control" id="datepicker"
                                       value="<fmt:formatDate value="${now}" pattern="MM/dd/yyyy"/>"
                                       name="date">
                            </div>
                        </div>
                        <button type="submit" class="btn btn-primary">Создать</button>
                    </form>
                </div>
            </main-content>
        </div>
        <div class="col-md-2"></div>
    </div>
</main>