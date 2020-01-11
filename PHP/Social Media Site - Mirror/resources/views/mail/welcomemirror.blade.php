@component('mail::message')

    Hello {{$user->name}},

    Welcome to the world of your reflection.

    Thank you for joining us.

    Thanks,
    {{config('app.name')}}

@endcomponent
