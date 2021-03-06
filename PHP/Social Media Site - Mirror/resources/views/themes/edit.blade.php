@extends('layouts.app')

@section('content')
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-8">
                <div class="card">
                    <div class="card-header">{{ __('Add Themes') }}</div>

                    <div class="card-body">
                        <form method="POST" action="/themes/{{$theme->id}}">
                            @method('PATCH')
                            @csrf

                            <div class="form-group row">
                                <label for="name" class="col-md-4 col-form-label text-md-right">{{ __('Name') }}</label>

                                <div class="col-md-6">
                                    <input id="name" type="text" class="form-control{{ $errors->has('name') ? ' is-invalid' : '' }}" name="name" value="{{$theme->name}}" required autofocus>

                                    @if ($errors->has('name'))
                                        <span class="invalid-feedback" role="alert">
                                        <strong>{{ $errors->first('name') }}</strong>
                                        </span>
                                    @endif
                                </div>
                            </div>

                            <div class="form-group row">
                                <label for="cdn_url" class="col-md-4 col-form-label text-md-right">{{ __('CDN URL') }}</label>

                                <div class="col-md-6">
                                    <input id="cdn_url" type="text" class="form-control{{ $errors->has('cdn_url') ? ' is-invalid' : '' }}" name="cdn_url" value="{{$theme->cdn_url}}" required>

                                    @if ($errors->has('cdn_url'))
                                        <span class="invalid-feedback" role="alert">
                                        <strong>{{ $errors->first('cdn_url') }}</strong>
                                        </span>
                                    @endif
                                </div>
                            </div>

                            <div class="form-group row">
                                <label for="description" class="col-md-4 col-form-label text-md-right">{{ __('Description') }}</label>

                                <div class="col-md-6">
                                    <input id="description" type="text" class="form-control{{ $errors->has('description') ? ' is-invalid' : '' }}" name="description" value="{{$theme->description}}" required>

                                    @if ($errors->has('description'))
                                        <span class="invalid-feedback" role="alert">
                                        <strong>{{ $errors->first('description') }}</strong>
                                        </span>
                                    @endif
                                </div>
                            </div>

                            <div class="row justify-content-center">
                                <label for="is_default">
                                    <input type="checkbox" id="is_default" name="is_default" {{$theme->is_default ? 'checked':''}}>
                                    Make this default theme.
                                </label>
                            </div>

                            <div class="row justify-content-center">
                                <div class="col-md-6 offset-md-4">
                                    <button type="submit" class="btn btn-primary">
                                        {{ __('Update') }}
                                    </button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
@endsection


