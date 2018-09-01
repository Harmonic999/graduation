var dataTableApi;

$(function () {
    dataTableApi = $("#datatable").DataTable(
        {
            "paging": false,
            "info": true,
            "columns": [
                {"data": "description"},
                {
                    "defaultContent": "Edit",
                    "orderable": false
                },
                {
                    "defaultContent": "Delete",
                    "orderable": false
                }
            ],
            "order": [
                0,
                "asc"
            ]
        }
    );
    makeEditable();
});