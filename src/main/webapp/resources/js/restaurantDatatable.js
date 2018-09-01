var dataTableApi;

$(function () {
    dataTableApi = $("#datatable").DataTable(
        {
            "paging": false,
            "info": true,
            "columns": [
                {"data": "name"},
                {"data": "score"},
                {
                    "defaultContent": "Explore",
                    "orderable": false
                },
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