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
            "columns": foodListDrawProperties,
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