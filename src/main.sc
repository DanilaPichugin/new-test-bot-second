require: dateTime/dateTime.sc
  module = sys.zb-common
theme: /

    state: Start
        q!: $regex</start>
        a: Начнём.

    state: Hello
        intent!: /привет
        a: Привет привет

    state: Date
        intent!: /текущая дата
        script: 
            $temp.date = currentDate();
        a: Сегодня {{$temp.date.format("DD.MM.YYYY")}}
    
    state: Week day
        intent!: /день недели
        script: 
            $temp.date = currentDate();
        a: {{$temp.date.format("dddd")}}        

    state: NoMatch
        event!: noMatch
        a: Я не понял. Вы сказали: {{$request.query}}
