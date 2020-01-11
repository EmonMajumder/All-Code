
@extends('layouts.app')

@section('content')
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-20">
                <div class="card">
                    <div class="card-header">{{ __('Themes') }}</div>

                    <div class="card-body">
                        <div class="row justify-content-center">
                            <table style="border: 1px solid black;">
                                <thead>
                                <tr>
                                    <td align="center" style="border: 1px solid black;">ID</td>
                                    <td align="center" style="border: 1px solid black;">Name</td>
                                    <td align="center" style="border: 1px solid black;">cdn_url</td>
                                    <td align="center" style="border: 1px solid black;">Description</td>
                                    <td align="center" style="border: 1px solid black;">Status</td>
                                    @if(auth()->user()->hasrole('Theme Manager'))
                                        <td align="center" style="border: 1px solid black;">Created By</td>
                                        <td align="center" style="border: 1px solid black;">Created At</td>
                                        <td align="center" style="border: 1px solid black;">Last Modified By</td>
                                        <td align="center" style="border: 1px solid black;">Last Modified At</td>
                                        <td align="center" style="border: 1px solid black;">Deleted By</td>
                                        <td align="center" style="border: 1px solid black;">Deleted AT</td>
                                        <td align="center" style="border: 1px solid black;" colspan="2">Action</td>
                                    @endif
                                </tr>
                                </thead>
                                <tbody>
                                @foreach($themes=\App\Theme::all() as $theme)
                                    <tr>
                                        <td align="center" style="border: 1px solid black;">{{$theme->id}}</td>
                                        <td align="center" style="border: 1px solid black;">{{$theme->name}}</td>
                                        <td align="center" style="border: 1px solid black;">{{$theme->cdn_url}}</td>
                                        <td align="center" style="border: 1px solid black;">{{$theme->description}}</td>
                                        <td align="center" style="border: 1px solid black;">
                                            <form name="checkboxsubmit" method="POST" action="/themes/{{$theme->id}}">
                                                @method('PATCH')
                                                @csrf
                                                <input hidden name="check" value="yes"/>
                                                <input hidden name="name" value="{{$theme->name}}"/>
                                                <input hidden name="cdn_url" value="{{$theme->cdn_url}}"/>
                                                <input hidden name="description" value="{{$theme->description}}"/>
                                                <label>
                                                    @if(auth()->user()->hasrole('Theme Manager') || !Request()->cookie('theme'))
                                                        <input type="checkbox" name="is_default" onchange="this.form.submit()" {{$theme->is_default ? 'checked':''}}>
                                                    @elseif(Request()->cookie('theme'))
                                                        <input type="checkbox" name="is_default" onchange="this.form.submit()" {{Request()->cookie('theme') == $theme->cdn_url ? 'checked':''}}>
                                                    @endif
                                                </label>
                                            </form>
                                        </td>
                                        @if(auth()->user()->hasrole('Theme Manager'))
                                            <td align="center" style="border: 1px solid black;">{{$theme->created_by}}</td>
                                            <td align="center" style="border: 1px solid black;">{{$theme->created_at}}</td>
                                            <td align="center" style="border: 1px solid black;">{{$theme->last_modified_by}}</td>
                                            <td align="center" style="border: 1px solid black;">{{$theme->updated_at}}</td>
                                            <td align="center" style="border: 1px solid black;">{{$theme->deleted_by}}</td>
                                            <td align="center" style="border: 1px solid black;">{{$theme->deleted_at}}</td>

                                            <td align="center" style="border: 1px solid black;">
                                                @if($theme->is_default == false)
                                                    <input type="button" onclick="location.href='/themes/{{$theme->id}}/edit';" value="Edit" />
                                                @endif
                                            </td>

                                            <td align="center" style="border: 1px solid black;">
                                                @if($theme->is_default == false)
                                                    <form action="/themes/{{$theme->id}}"  method="post">
                                                        @method('DELETE')
                                                        @csrf
                                                        <button type="submit" onclick="return confirm('Are you sure?')">Delete</button>
                                                    </form>
                                                @endif
                                            </td>
                                        @endif
                                    </tr>
                                @endforeach
                                </tbody>
                            </table>
                        </div>
                        <br>
                        <div class="row justify-content-center">
                            <input type="button" onclick="location.href='/themes/create';" value="Add Theme" />
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
@endsection

