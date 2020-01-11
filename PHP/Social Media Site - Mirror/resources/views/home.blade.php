@extends('layouts.layout')

@section('content')
<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-8">
            <div class="card">
                <div class="card-header">Dashboard</div>
                    <div class="card-body">
                        @if (session('status'))
                            <div class="alert alert-success" role="alert">
                                {{ session('status') }}
                            </div>
                        @endif

                        You are logged in!
                        <br>
                        <div class="row justify-content-center">
                            <div class="form-group row mb-0">
                                @if(auth()->user()->hasrole('User Administrator'))
                                    <p>&nbsp;</p>
                                    <input type="button" onclick="location.href='/users';" value="Users" />
                                    <p>&nbsp;</p>
                                @endif
                                @if(auth()->user()->hasrole('Theme Manager'))
                                    <p>&nbsp;</p>
                                    <input type="button" onclick="location.href='/themes';" value="Themes" />
                                    <p>&nbsp;</p>
                                @endif
                                    <p>&nbsp;</p>
                                    <input type="button" onclick="location.href='/posts';" value="Posts" />
                                    <p>&nbsp;</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
@endsection
