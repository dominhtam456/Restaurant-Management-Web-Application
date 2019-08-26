$('.btn-modal-in-modal').click(function(e){
    e.preventDefault();

    $('#modalAddFoods')
        .modal('hide')
        .on('hidden.bs.modal', function (e) {
            $('#test2').modal('show');
            $(this).off('hidden.bs.modal'); 
        });

});