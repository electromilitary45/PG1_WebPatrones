function buscarTablaServicio() {
    alert(hola);
    // Declare variables
    /*
    var input, filter, table, tr, td, i, txtValue;
    input = document.getElementById("texto");
    filter = input.value.toUpperCase();
    table = document.getElementById("tabla");
    tr = table.getElementsByTagName("tr");

    // Loop through all table rows, and hide those who don't match the search query
    for (i = 0; i < tr.length; i++) {
        td = tr[i].getElementsByTagName("td")[0];
        if (td) {
            txtValue = td.textContent || td.innerText;
            if (txtValue.toUpperCase().indexOf(filter) > -1) {
                tr[i].style.display = "";
            } else {
                tr[i].style.display = "none";
            }
        }
    }
     * 
     */
}
function showRec(){
    getSelectedValue = document.getElementById("status").value;
    
    if(getSelectedValue == "rechazada"){
        document.getElementById("fechaCitaRechazada").style.display = "inline-block";
        document.getElementById("lblFerchaRechazada").style.display = "inline-block";

        
    } else if (getSelectedValue != "Rechazada"){
        document.getElementById("fechaCitaRechazada").style.display = "none";
        document.getElementById("lblFerchaRechazada").style.display = "none";
    }
    
}
function showInp(){
    getSelectedValue = document.getElementById("status").value;
    
    if(getSelectedValue == "rechazada"){
        document.getElementById("fechaCitaRechazada").style.display = "inline-block";
        document.getElementById("lblFerchaRechazada").style.display = "inline-block";
        
    } else if (getSelectedValue != "Rechazada"){
        document.getElementById("fechaCitaRechazada").style.display = "none";
        document.getElementById("lblFerchaRechazada").style.display = "none";
    }
}



function fechaRecNuevo(){
    
    let fecha = document.getElementById('fechaCitaNuevo').value;
    document.getElementById('fechaCitaRechazadaNuevo').value=fecha;

}

function imprimir(){
    window.print();
}



 