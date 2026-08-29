@extends('layouts.app')

@section('content')
<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-12">
            @if (session('status'))
                <div class="alert alert-success">
                    {{ session('status') }}
                </div>
            @endif

            @if (session('failed'))
                <div class="alert alert-danger">
                    {{ session('failed') }}
                </div>
            @endif
            
            <div class="card">
                <div class="card-header">Data Pemesanan</div>
                <div class="card-body">
                <p>
                    <a href="/dashboard/pemesanan/create" class="btn btn-primary"> Tambah </a>
                </p>
                <div class="table-responsive">
                    <table class="table">
                    <thead>
                        <tr>
                        <th scope="col">#</th>
                        <th scope="col">Nama Barang</th>
                        <th scope="col">Jumlah Pesanan</th>
                        <th scope="col">Foto Barang</th>
                        <th scope="col">Harga Barang</th>
                        <th scope="col">Aksi</th>
                        </tr>
                    </thead>
                    <tbody>
                        @foreach($data as $row)
                        <tr>
                        <th scope="row">{{$row->id}}</th>
                        <td>{{$row->nama_barang}}</td>
                        <td>{{$row->jumlah_pesanan}}</td>
                        <td><img src="{{url('upload/'.$row->foto_barang)}}" width="100" alt="gambar_produk" /></td>
                        <td>Rp. {{number_format($row->harga_barang,0,',','.')}}</td>
                        <td>
                            <a href="/dashboard/pemesanan/edit/{{$row->id}}" class="btn btn-warning">Edit</a>
                            <a href="/dashboard/pemesanan/delete/{{$row->id}}" class="btn btn-danger" onclick="return confirm('Yakin Mau Hapus Data ini ??')">Delete</a>
                        </td>
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