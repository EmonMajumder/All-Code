<?php

namespace App\Http\Controllers;

use App\User;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Hash;

class UsersController extends Controller
{
    public function __construct()
    {
        $this->middleware('auth');
    }

    public function index()
    {
        $this->authorize('update',auth()->user());
        return view('users.index');
    }

    public function show()
    {
        $this->authorize('update',auth()->user());
        return view('users.show');
    }

    public function create()
    {
        auth()->user()->hasrole('');
        $this->authorize('update',auth()->user());
        return view('users.create');
    }

    public function edit(User $user)
    {
        $this->authorize('update',auth()->user());
        $this->authorize('delete',$user);
        return view('users.edit',compact('user'));
    }

    public function update(User $user)
    {
        $this->authorize('update',auth()->user());
        $attributes = $this->validateUserUpdate($user);
        $attributes['password'] = $attributes['password'];
        $attributes['updated_at'] = now();
        $attributes['last_modified_by'] = auth()->id();
        $user->update($attributes);
        return redirect('/users');
    }

    public function destroy(User $user)
    {
        $this->authorize('update',auth()->user());
        $this->authorize('delete',$user);
        $attribute['deleted_by'] = auth()->id();
        $user->update($attribute);
        $user->delete();
        return redirect('/users');
    }

    public function validateUserUpdate(User $user)
    {
        return request()->validate([
            'name' => ['required', 'string', 'max:255'],
            'email' => ['required', 'string', 'max:255', 'unique:themes,cdn_url,'.$user->id],
            'password' => ['required', 'string', 'min:6', 'confirmed']
        ]);
    }
}
