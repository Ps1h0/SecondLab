$(document).ready(function() {

    document.oncontextmenu = function () { return false; };
 
    let field;

    $('.attendance, .ul-attendance').mousedown(function (event) {            

        if (event.which === 1) {
            field.innerText = event.target.innerText;
            document.getElementById("context-menu-attendance").style.display = 'none';
        }
        if (event.which === 3 && $('#divMySubject .attendance').attr('class') == 'attendance') {
       
            field = event.target;

            document.getElementById("context-menu-attendance").style.display = '';
            $('.context-menu').css({ left: event.pageX + 'px', top: event.pageY + 'px' });
        }
    });

    $('.date, .ul-date').mousedown(function (event) {            

        if (event.which === 1) {
            
            $('#apply').click( () => {
                var date = new Date($('#menu-date').val());
                field.innerText = [date.getDate(), date.getMonth(), date.getFullYear()].join('.');
                document.getElementById("context-menu-date").style.display = 'none';
            })
        }
        if (event.which === 3 && $('#divMySubject .date').attr('class') == 'date') {
        
            field = event.target;

            document.getElementById("context-menu-date").style.display = '';
            $('.context-menu').css({ left: event.pageX + 'px', top: event.pageY + 'px' });
        }
    });
    
    $('.date').click( (event) => {
        $('#date-info').text(event.target.innerText);
        $('.date-info').css('display', 'block');
    })

});