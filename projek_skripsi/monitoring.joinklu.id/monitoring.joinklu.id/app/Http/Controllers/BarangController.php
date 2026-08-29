<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Barang;
// use Illuminate\Support\Facades\DB;

class BarangController extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index()
    {
        $data = Barang::paginate(10);
        return view('barang.index',compact('data'));
    }

    /**
     * Show the form for creating a new resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function create()
    {
         return view('barang.create');
    }

    /**
     * Store a newly created resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @return \Illuminate\Http\Response
     */
    public function store(Request $request)
    {
        if(!empty($request->file('foto_barang'))) {
            $foto = $request->file('foto_barang');
            $nama_file = $foto->getClientOriginalName();
            $newName = explode(".", $nama_file);
            $ext = end($newName);
            $ganti_nama = time().'.'.$ext;
            $destination = 'upload/';
            $foto->move($destination,$ganti_nama);

            $brg = new Barang();
            $brg->nama_barang = $request->nama_barang;
            $brg->stok_barang = $request->stok_barang;
            $brg->harga_barang = $request->harga_barang;
            $brg->foto_barang = $ganti_nama;
            $brg->deskripsi_barang = $request->deskripsi_barang;
            $brg->save();            
        } 
        return redirect('/dashboard/barang')->with('status', 'Barang created!');
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
        $data = Barang::findOrFail($id);
        return view('barang.edit',compact('data'));
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
        if(!empty($request->file('foto_barang'))) {
            $foto = $request->file('foto_barang');
            $nama_file = $foto->getClientOriginalName();
            $newName = explode(".", $nama_file);
            $ext = end($newName);
            $ganti_nama = time().'.'.$ext;
            $destination = 'upload/';
            $foto->move($destination,$ganti_nama);

            $brg = Barang::findOrFail($id);
            $brg->nama_barang = $request->nama_barang;
            $brg->stok_barang = $request->stok_barang;
            $brg->harga_barang = $request->harga_barang;
            $brg->foto_barang = $ganti_nama;
            $brg->deskripsi_barang = $request->deskripsi_barang;
            $brg->save();         

        } else {
            $brg = Barang::findOrFail($id);
            $brg->nama_barang = $request->nama_barang;
            $brg->stok_barang = $request->stok_barang;
            $brg->harga_barang = $request->harga_barang;
            $brg->deskripsi_barang = $request->deskripsi_barang;
            $brg->save();   
        }

        return redirect('/dashboard/barang')->with('status', 'Barang updated!');
    }

    /**
     * Remove the specified resource from storage.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function destroy($id, $foto)
    {
          if(!empty($foto)){
            $data = Barang::findOrFail($id);
            $data->delete();
            unlink(public_path('upload/'.$foto));
            return redirect('/dashboard/barang')->with('status', 'Barang Deleted!');
        }else{
            $data = Barang::findOrFail($id);
            $data->delete();
            return redirect('/dashboard/barang')->with('status', 'Barang Deleted!');
        }
    }
}
