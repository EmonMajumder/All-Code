<?php

namespace App\Http\Controllers;

use App\Theme;
use App\User;
use http\Cookie;
use Illuminate\Http\Request;
use App\Http\Controllers\UsersController;
use Illuminate\Http\Response;

class ThemesController extends Controller
{
    public function __construct()
    {
        $this->middleware('auth');
    }

    public function show()
    {
        return view('themes.index');
    }

    public function index()
    {
        return view('themes.index');
    }

    public function create()
    {
        auth()->user()->authorizeRoles('Theme Manager');
        return view('themes.create');
    }

    public function store()
    {
        auth()->user()->authorizeRoles('Theme Manager');
        $attributes = $this->validateTheme();
        $attributes['is_default'] = false;
        $attributes['created_by'] = auth()->id();
        Theme::create($attributes);
        return redirect('/themes');
    }

    public function edit(Theme $theme)
    {
        auth()->user()->authorizeRoles('Theme Manager');
        $this->authorize('update',$theme);
        return view('themes.edit',compact('theme'));
    }

    public function update(Theme $theme)
    {
        if(auth()->user()->hasRole('Theme Manager'))
        {
            if(!request()->check)
            {
                $this->authorize('update',$theme);
            }
            $attributes = $this->validateThemeUpdate($theme);
            if(request()->is_default)
            {
                $attributes['is_default']=true;
                $lastdefaulttheme = Theme::where('is_default',true)->first();
                $this->updateold($lastdefaulttheme);
            }
            else
            {
                if(Theme::where('is_default',true)->count() > 1)
                {
                    $attributes['is_default']=false;
                }
            }
            $attributes['last_modified_by'] = auth()->id();
            $attributes['updated_at'] = now();
            $theme->update($attributes);
            return redirect('/themes');
        }
        else
            return redirect('/themes')->withCookie(cookie()->forever('theme', $theme->cdn_url));
    }

    public function updateold(Theme $theme)
    {
        $att['is_default'] = false;
        $theme->update($att);
    }

    public function destroy(Theme $theme)
    {
        $this->authorize('update',$theme);
        $theme->delete();
        return redirect('/themes');
    }

    public function validateThemeUpdate(Theme $theme)
    {
        return request()->validate([
            'name' => ['required', 'string', 'max:255'],
            'cdn_url' => ['required', 'string', 'max:255', 'unique:themes,cdn_url,'.$theme->id],
            'description' => ['required', 'string']
        ]);
    }

    public function validateTheme()
    {
        return request()->validate([
            'name' => ['required', 'string', 'max:255'],
            'cdn_url' => ['required', 'string', 'max:255', 'unique:themes'],
            'description' => ['required', 'string']
        ]);
    }
}
