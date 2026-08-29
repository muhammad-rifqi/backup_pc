@extends('layouts.app')

@section('content')
<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-12">
            <h3>Penjualan Tanggal {{$tanggalnya}}</h3>
            <div class="card">
                <div class="card-header">Data Penjualan Berdasarkan Tanggal</div>
                <div class="card-body">
                <div class="table-responsive">
                    <table class="table">
                    <thead>
                        <tr>
                        <th scope="col">#</th>
                        <th scope="col">Total Penjualan</th>
                        <th scope="col">Nama Barang</th>
                        <th scope="col">Jumlah Pesanan</th>
                        <th scope="col">Harga Barang</th>
                        <th scope="col">Foto Barang</th>
                        <th scope="col">ID Pembeli</th>
                        </tr>
                    </thead>
                    <tbody>
                        @foreach($data as $row)
                        <tr>
                            <th scope="row">{{$row->id }}</th>
                            <td>{{number_format($row->total_penjualan,0,',',',')}}</td>
                            <td>{{$row->nama_barang}}</td>
                            <td>{{$row->jumlah_pesanan}}</td>
                            <td>{{$row->harga_barang}}</td>
                            <td><img src="{{url('upload/'.$row->foto_barang)}}" width="200" alt="gambar penjualan" /></td>
                            <td>{{$row->id_pembeli}}</td>
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