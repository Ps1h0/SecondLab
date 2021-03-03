// $(function(){

    $("#divMySchedule").load("schedule.html");

    $('.divRight').click(function (event) {

        $('#divMain').addClass('displayShow');
        $('#divMySchedule').addClass('displayShow');
        $('#divMySubjects').addClass('displayShow');
        $('#divMyGroups').addClass('displayShow');

          let target = $( event.target );
          if ( target.is( "#myMain" ) ) {
            $('#divMain').toggleClass('displayShow');
          }
          if ( target.is( "#mySchedule" ) ) {
            $('#divMySchedule').toggleClass('displayShow');
          }
          if ( target.is( "#mySubject" ) ) {
            $('#divMySubjects').toggleClass('displayShow');
          }
          if ( target.is( "#myGroups" ) ) {
            $('#divMyGroups').toggleClass('displayShow');
          }
    })

    $('#divMySubjects p').click((event) => {
      let target = $( event.target );
      alert('переход на таблицу предмета')
    })
        
// });