var dataTableApi;
const ajaxUrl = "ajax/menu/";

$(function () {
    dataTableApi = $("#datatable").DataTable(
        {
            "ajax":{
                "url": buildMenuUrlWithRestaurantId(),
                "dataSrc": ""
            },
            "paging": false,
            "info": true,
            "columns": [
                {
                    "data": "description",
                    "render": function (data, type, row) {
                        if (type === "display") {
                            return data;
                        }
                        return data;
                    }
                },
                {
                    "defaultContent": "Edit",
                    "orderable": false,
                    "render": function (data, type, row) {
                        if (type === "display") {
                            return "<a onclick='updateRow(getRestaurantIdFromCurrentPage()," + row.id + ");'>" +
                                "<span style='color: green; cursor: pointer' class='fa fa-pencil'></span></a>";
                        }
                    }
                },
                {
                    "defaultContent": "Delete",
                    "orderable": false,
                    "render": function renderDeleteBtn(data, type, row) {
                        if (type === "display") {
                            return "<a onclick='deleteRow(" + row.id + ");'>" +
                                "<span style='color: red; cursor: pointer' class='fa fa-remove'></span></a>";
                        }
                    }
                }
            ],
            "order": [
                0,
                "asc"
            ],
            "initComplete": makeEditable
        }
    );
});

function getRestaurantIdFromCurrentPage() {
    var currentUrl = window.location.href;
    var array = currentUrl.split("/");
    return array[4];

}

function buildMenuUrlWithRestaurantId() {
    return ajaxUrl + getRestaurantIdFromCurrentPage();
}

function save() {
    var form = $("#detailsForm");
    $.ajax({
        type: "POST",
        url: ajaxUrl + getRestaurantIdFromCurrentPage(),
        data: form.serialize(),
        success: function () {
            $("#editRow").modal("hide");
            updateTable();
            successNoty("Saved");
        }
    });
}

function updateTable() {
    $.get(ajaxUrl + getRestaurantIdFromCurrentPage(), function (data) {
        dataTableApi.clear().rows.add(data).draw();
    });
}

function updateRow(restId, foodId) {
    $("#modalTitle").html("Update");
    $.get(ajaxUrl + restId + "/" + foodId, function (data) {
        $.each(data, function (key, value) {
            form.find("input[name='" + key + "']").val(value);
        });
        $('#editRow').modal();
    });
}