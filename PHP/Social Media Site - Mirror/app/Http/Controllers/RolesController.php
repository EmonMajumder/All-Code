<?php

namespace App\Http\Controllers;

use App\User;
use App\Role;
use Illuminate\Http\Request;

class RolesController extends Controller
{
    public function __construct()
    {
        $this->middleware('auth');
    }

    public function show(User $user)
    {

    }

    public function create(User $user)
    {

    }

    public function edit(User $user)
    {

    }

    public function update(User $user, Role $role)
    {
        $this->authorize('update',$user);
        $user->roles()->attach(Role::where('name',$role->name)->first());
        return redirect('/users');
    }

    public function destroy(User $user,Role $role)
    {
        $this->authorize('update',$user);
        if($user->id !=1 || $role->id !=1)
        {
            $user->roles()->detach(Role::where('name',$role->name)->first());
        }
        return redirect('/users');
    }
}
