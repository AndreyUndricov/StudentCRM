<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<main>
    <div class="row">
        <div class="col-sm-2">
            <nav>
                <div id="divNav" class="row">
                    <a id="home" href="/" class="btn btn-outline-secondary btn-sm">На главную</a>
                    <a id="back" href="/disciplines" class="btn btn-outline-secondary btn-sm">Назад</a>
                </div>

            </nav>
        </div>
        <div class="col-md-8">
            <main-content>
                <h3>Для создания дисицплины введите название и нажмите "Создать"</h3>
                <div class="student-form">
                    <form method="post" action="/disciplinecreating">
                        <div class="form-group row">
                            <label for="Name" class="col-sm-3 col-form-label">Название</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" id="Name" placeholder="Математика"
                                       name="discName">
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
