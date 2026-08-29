@extends('layouts.app')

@section('content')
<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-12">
            <div class="card">
                <div class="card-header">Data Penjualan Berdasarkan Tanggal</div>
                <div class="card-body">
                <div class="table-responsive">
                    <table class="table">
                    <thead>
                        <tr>
                        <th scope="col">#</th>
                        <th scope="col">Tanggal Penjualan</th>
                        <th scope="col">Aksi</th>
                        </tr>
                    </thead>
                    <tbody>
                        @foreach($data as $key =>  $row)
                        <tr>
                        <th scope="row">{{$key + 1 }}</th>
                        <td>{{$row->tanggal_penjualan}}</td>
                        <td><a href="/dashboard/penjualan/show/{{$row->tanggal_penjualan}}" class="btn btn-primary">View</a></td>
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