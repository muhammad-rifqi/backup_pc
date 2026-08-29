<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Pembeli;

class PembeliController extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index()
    {
        $data = Pembeli::paginate(10);
        return view('pembeli.index',compact('data'));
    }

    /**
     * Show the form for creating a new resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function create()
    {
        return view('pembeli.create');
    }

    /**
     * Store a newly created resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @return \Illuminate\Http\Response
     */
    public function store(Request $request)
    {
        $a = new Pembeli();
        $a->nama = $request->nama;
        $a->email = $request->email;
        $a->alamat = $request->alamat;
        $a->no_telepon = $request->no_telepon;
        $a->kode_pos = $request->kode_pos;
        $a->save();
        return redirect('/dashboard/pembeli')->with('status', 'Pembeli created!');
    }

    /**
     * Display the specified resource.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function show($id)
    {
        //
    }

    /**
     * Show the form for editing the specified resource.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function edit($id)
    {
        $data = Pembeli::findOrFail($id);
        return view('pembeli.edit',compact('data'));
    }

    /**
     * Update the specified resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function update(Request $request, $id)
    {
        $data = Pembeli::findOrFail($id);
        $data->nama = $request->nama;
        $data->email = $request->email;
        $data->alamat = $request->alamat;
        $data->no_telepon = $request->no_telepon;
        $data->kode_pos = $request->kode_pos;
        $data->save();
        return redirect('/dashboard/pembeli')->with('status', 'Pembeli updated!');
    }

    /**
     * Remove the specified resource from storage.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function destroy($id)
    {
        $data = Pembeli::findOrFail($id);
        $data->delete();
        return redirect('/dashboard/pembeli')->with('status', 'Pembeli deleted!');
    }
}
