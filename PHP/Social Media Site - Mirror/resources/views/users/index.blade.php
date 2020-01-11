@extends('layouts.app')

@section('content')
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-10">
                <div class="card">
                    <div class="card-header">{{ __('Users') }}</div>
                    <div class="card-body">
                        <div class="row justify-content-center">
                            <div class="form-group row mb-0">
                                <form method="POST" action="/users" role="search">
                                    @csrf
                                    <input id="search" type="text" name="search" placeholder="Search users" value="@if(isset($_POST['search'])){{$_POST['search']}}@endif" required autofocus>
                                    <?php
                                    use \App\User;
                                    use \App\Role;
                                    if(isset($_POST['search']))
                                    {
                                        $users = User::where('name','LIKE','%'.$_POST['search'].'%')->orWhere('email','LIKE','%'.$_POST['search'].'%')->get();
                                    }
                                    else
                                    {
                                        $users = User::whereHas('roles',function($query){
                                            $query->where('name','=','Theme Manager')->orWhere('name','=','User Administrator')->orWhere('name','=','Post Moderator');
                                        })->get();
                                    }
                                    ?>
                                    <button type="submit" class="btn btn-primary">
                                        {{ __('Search') }}
                                    </button>
                                </form>
                            </div>
                        </div>
                    </div>
                    <div class="card-body">
                        <div class="row justify-content-center">
                            <table style="border: 1px solid black;">
                                <thead>
                                <tr>
                                    <td align="center" style="border: 1px solid black;">ID</td>
                                    <td align="center" style="border: 1px solid black;">Name</td>
                                    <td align="center" style="border: 1px solid black;">email</td>
                                    <td align="center" style="border: 1px solid black;" colspan="3">Role</td>
                                    <td align="center" style="border: 1px solid black;" colspan="2">Action</td>
                                </tr>
                                </thead>
                                <tbody>
                                @foreach($users as $user)
                                    <tr>
                                        <td align="center" style="border: 1px solid black;">{{$user->id}}</td>
                                        <td align="center" style="border: 1px solid black;">{{$user->name}}</td>
                                        <td align="center" style="border: 1px solid black;">{{$user->email}}</td>

                                        @foreach(\App\Role::all() as $role)
                                            <td align="center" style="border: 1px solid black;">
                                                <form name="checkboxsubmit" method="POST" action="/users/{{$user->id}}/{{$role->id}}">
                                                    @if($user->hasRole($role->name))
                                                        @method('DELETE')
                                                    @else
                                                        @method('PATCH')
                                                    @endif
                                                    @csrf
                                                    @if($user->id != 1 || $role->id != 1)
                                                        <label>
                                                            <input type="checkbox" name="completed" onchange="this.form.submit()" {{$user->hasRole($role->name) ? 'checked':''}}>
                                                            {{$role->name}}
                                                        </label>
                                                    @endif
                                                </form>
                                            </td>
                                        @endforeach

                                        <td align="center" style="border: 1px solid black;">
                                            @if($user->id != 1)
                                                <input type="button" onclick="location.href='/users/{{$user->id}}/edit';" value="Edit" />
                                            @endif
                                        </td>
                                        <td align="center" style="border: 1px solid black;">
                                            @if($user->id != 1)
                                                <form action="/users/{{$user->id}}"  method="post">
                                                    @method('DELETE')
                                                    @csrf
                                                    <button type="submit" onclick="return confirm('Are you sure?')">Delete</button>
                                                </form>
                                            @endif
                                        </td>
                                    </tr>
                                @endforeach
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
@endsection
