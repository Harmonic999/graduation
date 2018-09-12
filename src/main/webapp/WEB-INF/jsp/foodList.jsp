<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<jsp:include page="fragments/headTag.jsp"/>
<body>
<jsp:include page="fragments/bodyHeader.jsp"/>
<script type="text/javascript" src="resources/js/datatableUtil.js" defer></script>
<script type="text/javascript" src="resources/js/foodDatatable.js" defer></script>

<div class="jumbotron">
    <div class="container">

        <h2>Lunch menu:</h2>

        <hr>

        <table id="datatable" class="table table-striped">

            <thead>
            <tr>
                <th>Description</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
            </thead>

        </table>

        <button class="btn btn-primary pull-right" onclick="add()">
            Add New
            <span class="fa fa-plus"></span>
        </button>

    </div>
</div>

<div class="modal fade" tabindex="-1" id="editRow">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title" id="modalTitle"></h4>
                <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>
            <div class="modal-body">
                <form id="detailsForm">
                    <input type="hidden" id="id" name="id">

                    <input type="hidden" id="restaurantId" name="restaurantId" value="">

                    <div class="form-group">
                        <label for="description" class="col-form-label">Description</label>
                        <input type="text" class="form-control" id="description" name="description"
                               placeholder="description">
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">
                    <span class="fa fa-close"></span>

                </button>
                <button type="button" class="btn btn-primary" onclick="save()">
                    <span class="fa fa-check"></span>
                </button>
            </div>
        </div>
    </div>
</div>

<jsp:include page="fragments/bodyFooter.jsp"/>
</body>
</html>