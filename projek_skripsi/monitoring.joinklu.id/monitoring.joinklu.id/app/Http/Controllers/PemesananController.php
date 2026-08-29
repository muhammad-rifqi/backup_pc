<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use Response;
use App\Pemesanan;
use App\Barang;
use Session;
use App\Pembeli;
use App\Penjualan;
class PemesananController extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index()
    {
        $data = Pemesanan::paginate(10);
        return view('pemesanan.index',compact('data'));
    }

    /**
     * Show the form for creating a new resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function create()
    {
        $data = Barang::all();
        $beli = Pembeli::all();
        $sess = Session::getId();
        return view('pemesanan.create',compact('data','sess','beli'));
    }

    public function views($id)
    {
        $detail = Barang::findOrFail($id);
        return Response::json($detail);
    }

    /**
     * Store a newly created resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @return \Illuminate\Http\Response
     */
    public function store(Request $request)
    {
            $orders = new Pemesanan();
            $orders->id_barang = $request->id_barang;
            $orders->nama_barang = $request->nama_barang;
            $orders->harga_barang = $request->harga_barang;
            $orders->foto_barang = $request->foto_barang;
            $orders->jumlah_pesanan = $request->jumlah_pesanan;
            $orders->session_id = $request->session_id;
            $orders->status_barang = $request->status_barang;
            $orders->id_pembeli = $request->id_pembeli;
            $orders->save();            
            return redirect('/dashboard/pemesanan')->with('status', 'Pemesanan created!');
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
        $data = Barang::all();
        $beli = Pembeli::all();
        $detail = Pemesanan::findOrFail($id);
        return view('pemesanan.edit',compact('detail','beli','data'));
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
        if($request->status_barang == '1'){
            $orders = Pemesanan::findOrFail($id);
            $orders->id_barang = $request->id_barang;
            $orders->nama_barang = $request->nama_barang;
            $orders->harga_barang = $request->harga_barang;
            $orders->jumlah_pesanan = $request->jumlah_pesanan;
            $orders->session_id = $request->session_id;
            $orders->id_pembeli = $request->id_pembeli;  
            $orders->status_barang = $request->status_barang;
            if($orders->save()){
                $brg = Barang::findOrFail($orders->id_barang);
                $check = ($brg->stok_barang - $request->jumlah_pesanan);
                if($check > 1){
                    $brg->stok_barang = $check;
                        if($brg->save()){
                            $jual = new Penjualan();
                            $jual->total_penjualan = $request->harga_barang * $request->jumlah_pesanan;
                            $jual->diskon_penjualan = 0;
                            $jual->tanggal_penjualan = date('Y-m-d');
                            $jual->id_pembeli = $request->id_pembeli; ;
                            $jual->id_barang = $request->id_barang;
                            $jual->id_supplier = 0;
                            $jual->nama_barang = $request->nama_barang;
                            $jual->jumlah_pesanan = $request->jumlah_pesanan;
                            $jual->harga_barang = $request->harga_barang;
                            $jual->foto_barang = $request->foto_barang;
                            $jual->nama_supplier = "-";
                            $jual->nama_pembeli = "-";
                            $jual->save();
                            return redirect('/dashboard/pemesanan')->with('status', 'Pemesanan Updated!');
                        }else{
                            return redirect('/dashboard/pemesanan')->with('failed', 'Gagal Insert Ke Penjualan!');
                        }
                        
                }else{
                        return redirect('/dashboard/pemesanan')->with('failed', 'Gagal Update Stok, Coba Ulangi Lagi!');
                }
            }else{
                return redirect('/dashboard/pemesanan')->with('status', 'Pemesanan Gagal Updated!');
            }
        }else{
            $orders = Pemesanan::findOrFail($id);
            $orders->id_barang = $request->id_barang;
            $orders->nama_barang = $request->nama_barang;
            $orders->harga_barang = $request->harga_barang;
            $orders->jumlah_pesanan = $request->jumlah_pesanan;
            $orders->session_id = $request->session_id;
            $orders->id_pembeli = $request->id_pembeli;  
            $orders->status_barang = $request->status_barang;
            $orders->save();
            return redirect('/dashboard/pemesanan')->with('status', 'Pemesanan Updated!');
        }   
    }
    /**
     * Remove the specified resource from storage.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function destroy($id)
    {
        $brg = Pemesanan::findOrFail($id);
        $brg->delete();
        return redirect('/dashboard/pemesanan')->with('status', 'Pemesanan Deleted!');
    }
}
