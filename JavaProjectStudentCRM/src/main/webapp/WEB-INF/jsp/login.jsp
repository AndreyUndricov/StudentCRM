<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<div id="container" class="container-fluid">
    <div class="row">
        <div class="col-sm-2">
            <nav>
                <div id="divNav" class="row">
                    <a id="home" href="/" class="btn btn-outline-secondary btn-sm">На главную</a>
                </div>
            </nav>
        </div>
        <div class="col-md-8">
            <section>
                <div id="containerForm" class="row">
                    <form class="needs-validation was-validated" action="login" method="post">
                        <div id="titleForm" class="form-group row">
                            Для входа заполните все поля и нажмите кнопку "Войти":
                        </div>
                        <div class="form-group row">
                            <label for="loginID" class="col-sm-2 col-form-label">Логин*</label>
                            <div class="col-sm-6">
                                <input type="text" class="form-control" id="loginID" name="login"
                                       placeholder="Логин"
                                       required>
                            </div>
                            <div class="valid-tooltip">Хорошо!</div>
                            <div class="invalid-tooltip">Заполните это поле!</div>
                        </div>
                        <div class="form-group row">
                            <label for="passId" class="col-sm-2 col-form-label">Пароль*</label>
                            <div class="col-sm-6">
                                <input type="password" class="form-control" id="passId" name="pass" placeholder="****"
                                       required>
                            </div>
                            <div class="valid-tooltip">Хорошо!</div>
                            <div class="invalid-tooltip">Заполните это поле!</div>
                        </div>
                        <div class="form-group row">
                            <label for="roleID" class="col-sm-2 col-form-label">Роль*</label>
                            <div class="col-sm-6">
                                <select class="form-control" id="roleID" name="role">
                                    <option value="1">Администратор</option>
                                    <option value="2">Студент</option>
                                    <option value="3">Учитель</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group row">
                            <div class="col-sm-2"></div>
                            <div class="col-sm-3">
                                <button type="submit" class="btn btn-outline-secondary btn btn-block">Войти</button>
                            </div>
                        </div>
                        <div class="form-group row">
                            <div class="col-sm-2"></div>
                            <div class="col-md-6">

                            </div>
                        </div>

                    </form>
                </div>
            </section>
            <c:if test="${errorMessage eq 1}">
                <div class="alert alert-danger" role="alert">
                    Проверьте правильность ввода данных!
                </div>
            </c:if>
        </div>
        <div class="col-sm-2"></div>
    </div>
</div>
