-- phpMyAdmin SQL Dump
-- version 5.2.2
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Jun 09, 2025 at 02:22 PM
-- Server version: 10.11.11-MariaDB-cll-lve
-- PHP Version: 8.3.20

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `u1584051_monitoring_produk`
--

-- --------------------------------------------------------

--
-- Table structure for table `barangs`
--

CREATE TABLE `barangs` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `nama_barang` varchar(255) NOT NULL,
  `stok_barang` int(11) NOT NULL,
  `harga_barang` int(11) NOT NULL,
  `foto_barang` varchar(255) NOT NULL,
  `deskripsi_barang` text NOT NULL,
  `id_kategori` int(11) NOT NULL DEFAULT 0,
  `id_supplier` int(11) NOT NULL DEFAULT 0,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `barangs`
--

INSERT INTO `barangs` (`id`, `nama_barang`, `stok_barang`, `harga_barang`, `foto_barang`, `deskripsi_barang`, `id_kategori`, `id_supplier`, `created_at`, `updated_at`) VALUES
(1, 'pupuk alam dan pupuk buatan', 12, 50000, '1749181572.jpeg', 'Pupuk alam adalah pupuk yang terbuat dari bahan alami seperti kompos, pupuk kandang, dan pupuk guano. Pupuk buatan, di sisi lain, adalah pupuk yang dibuat di pabrik dengan mengolah bahan mineral melalui proses kimia atau fisika', 0, 0, '2025-05-27 09:20:47', '2025-06-05 20:46:12'),
(3, 'Pupuk padat dan pupuk cair', 20, 100000, '1749181725.jpg', 'Pupuk Padat adalah pupuk yang memiliki bentuk fisik padatan dengan kelarutan yang beragam. Kebanyakan merupakan pupuk yang menganduk unsur hara makro. Contoh pupuk padat adalah pupuk tablet, pupuk briket, pupuk granul, dll. Pupuk Cair adalah pupuk yang memiliki bentuk fisik cair', 0, 0, '2025-05-28 04:57:03', '2025-06-05 20:48:45'),
(4, 'Pupuk Tunggal', 8, 50000, '1749192418.jpg', 'Pupuk yang mengandung satu unsur hara tertentu, contohnya pupuk urea yang mengandung nitrogen', 0, 0, '2025-06-05 23:46:58', '2025-06-08 06:17:17'),
(5, 'Pupuk Majemuk', 25, 60000, '1749192499.jpg', 'Pupuk yang mengandung lebih dari satu unsur hara, seperti pupuk NPK yang mengandung nitrogen, fosfor, dan kalium', 0, 0, '2025-06-05 23:48:19', '2025-06-05 23:48:19'),
(6, 'Pupuk Cepat Tersedia', 15, 28000, '1749192616.jpg', 'Pupuk yang unsur haranya mudah diserap oleh tanaman, seperti pupuk urea dan SP-36.', 0, 0, '2025-06-05 23:50:16', '2025-06-05 23:50:16'),
(7, 'Pupuk Lambat Tersedia', 20, 30000, '1749192731.jpg', 'upuk yang unsur haranya diserap oleh tanaman secara bertahap, seperti pupuk kandang dan pupuk kompos.', 0, 0, '2025-06-05 23:52:11', '2025-06-05 23:52:11'),
(8, 'Pupuk Organik', 30, 10000, '1749192812.jpg', 'Pupuk yang berasal dari bahan organik, seperti pupuk kompos, pupuk kandang, dan pupuk humus', 0, 0, '2025-06-05 23:53:32', '2025-06-05 23:53:32'),
(9, 'Pupuk Anorganik', 20, 10000, '1749192892.jpg', 'Pupuk yang berasal dari bahan anorganik, seperti pupuk urea, SP-36, dan NPK.', 0, 0, '2025-06-05 23:54:52', '2025-06-05 23:54:52'),
(10, 'Pupuk Makro', 20, 50000, '1749192969.jpg', 'Pupuk yang mengandung unsur hara makro, seperti nitrogen (N), fosfor (P), dan kalium (K).', 0, 0, '2025-06-05 23:56:09', '2025-06-05 23:56:09'),
(11, 'Pupuk Mikro', 20, 30000, '1749193040.jpg', 'Pupuk yang mengandung unsur hara mikro, seperti tembaga (Cu), boron (B), dan seng (Zn).', 0, 0, '2025-06-05 23:57:20', '2025-06-05 23:57:20');

-- --------------------------------------------------------

--
-- Table structure for table `failed_jobs`
--

CREATE TABLE `failed_jobs` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `connection` text NOT NULL,
  `queue` text NOT NULL,
  `payload` longtext NOT NULL,
  `exception` longtext NOT NULL,
  `failed_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `kategoris`
--

CREATE TABLE `kategoris` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `nama_kategori` varchar(255) NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `kategoris`
--

INSERT INTO `kategoris` (`id`, `nama_kategori`, `created_at`, `updated_at`) VALUES
(2, 'Kategori A', '2025-05-28 02:13:32', '2025-05-28 02:13:32');

-- --------------------------------------------------------

--
-- Table structure for table `laporans`
--

CREATE TABLE `laporans` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `migrations`
--

CREATE TABLE `migrations` (
  `id` int(10) UNSIGNED NOT NULL,
  `migration` varchar(255) NOT NULL,
  `batch` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `migrations`
--

INSERT INTO `migrations` (`id`, `migration`, `batch`) VALUES
(1, '2014_10_12_000000_create_users_table', 1),
(2, '2014_10_12_100000_create_password_resets_table', 1),
(25, '2019_08_19_000000_create_failed_jobs_table', 7),
(34, '2025_05_27_085637_create_pembelis_table', 8),
(35, '2025_05_27_091057_create_penjualans_table', 8),
(36, '2025_05_27_091121_create_barangs_table', 8),
(37, '2025_05_27_091137_create_laporans_table', 8),
(38, '2025_05_27_092846_create_kategoris_table', 8),
(39, '2025_05_27_092906_create_supliers_table', 8),
(40, '2025_05_28_022602_add_nama_barang_to_penjualans_table', 9),
(41, '2025_05_28_023132_create_pemesanans_table', 9),
(42, '2025_05_28_093133_add_id_pembeli_to_pemesanans_table', 10);

-- --------------------------------------------------------

--
-- Table structure for table `password_resets`
--

CREATE TABLE `password_resets` (
  `email` varchar(255) NOT NULL,
  `token` varchar(255) NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `pembelis`
--

CREATE TABLE `pembelis` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `nama` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `no_telepon` varchar(255) NOT NULL,
  `alamat` text NOT NULL,
  `kode_pos` int(11) NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `pembelis`
--

INSERT INTO `pembelis` (`id`, `nama`, `email`, `no_telepon`, `alamat`, `kode_pos`, `created_at`, `updated_at`) VALUES
(2, 'Muhammad Rifqi Saja', 'muhammad45rifki@gmail.com', '085280136585', 'ciputat, tangerang selatan', 15412, '2025-05-27 09:53:22', '2025-05-27 09:55:34');

-- --------------------------------------------------------

--
-- Table structure for table `pemesanans`
--

CREATE TABLE `pemesanans` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `id_barang` int(11) NOT NULL,
  `nama_barang` varchar(255) NOT NULL,
  `harga_barang` int(11) NOT NULL,
  `foto_barang` varchar(255) NOT NULL,
  `jumlah_pesanan` varchar(255) NOT NULL,
  `session_id` varchar(255) NOT NULL,
  `status_barang` int(11) NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  `id_pembeli` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `pemesanans`
--

INSERT INTO `pemesanans` (`id`, `id_barang`, `nama_barang`, `harga_barang`, `foto_barang`, `jumlah_pesanan`, `session_id`, `status_barang`, `created_at`, `updated_at`, `id_pembeli`) VALUES
(3, 4, 'Pupuk Tunggal', 50000, '1749192418.jpg', '12', '4i4udlzzLXo62AcoQgNzbDXLuCV6YODswAOknlb7', 1, '2025-06-08 06:17:10', '2025-06-08 06:17:17', 2);

-- --------------------------------------------------------

--
-- Table structure for table `penjualans`
--

CREATE TABLE `penjualans` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `total_penjualan` int(11) DEFAULT NULL,
  `diskon_penjualan` int(11) DEFAULT NULL,
  `tanggal_penjualan` date NOT NULL,
  `id_pembeli` int(11) NOT NULL,
  `id_barang` int(11) NOT NULL,
  `id_supplier` int(11) NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  `nama_barang` varchar(255) NOT NULL,
  `jumlah_pesanan` int(11) NOT NULL,
  `harga_barang` int(11) NOT NULL,
  `foto_barang` varchar(255) NOT NULL,
  `nama_supplier` varchar(255) NOT NULL,
  `nama_pembeli` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `penjualans`
--

INSERT INTO `penjualans` (`id`, `total_penjualan`, `diskon_penjualan`, `tanggal_penjualan`, `id_pembeli`, `id_barang`, `id_supplier`, `created_at`, `updated_at`, `nama_barang`, `jumlah_pesanan`, `harga_barang`, `foto_barang`, `nama_supplier`, `nama_pembeli`) VALUES
(1, 600000, 0, '2025-06-08', 2, 4, 0, '2025-06-08 06:17:17', '2025-06-08 06:17:17', 'Pupuk Tunggal', 12, 50000, '1749192418.jpg', '-', '-');

-- --------------------------------------------------------

--
-- Table structure for table `suppliers`
--

CREATE TABLE `suppliers` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `nama` varchar(255) NOT NULL,
  `alamat` varchar(255) NOT NULL,
  `telepon` varchar(255) NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `suppliers`
--

INSERT INTO `suppliers` (`id`, `nama`, `alamat`, `telepon`, `created_at`, `updated_at`) VALUES
(2, 'Muhammad Rifqi Saja', 'ciputat, tangerang selatan indonesia', '085280136785', '2025-05-27 22:18:17', '2025-05-29 05:18:38');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `email_verified_at` timestamp NULL DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `remember_token` varchar(100) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `name`, `email`, `email_verified_at`, `password`, `remember_token`, `created_at`, `updated_at`) VALUES
(1, 'Rifqi Muhammad', 'admin@gmail.com', NULL, '$2y$10$YOu/ugus4Jz547cedXV21eJrWwRLAS1gFi3ohTXswXxiYvyKkpGpC', NULL, '2023-06-10 22:58:20', '2023-06-10 22:58:20');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `barangs`
--
ALTER TABLE `barangs`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `failed_jobs`
--
ALTER TABLE `failed_jobs`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `kategoris`
--
ALTER TABLE `kategoris`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `laporans`
--
ALTER TABLE `laporans`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `migrations`
--
ALTER TABLE `migrations`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `password_resets`
--
ALTER TABLE `password_resets`
  ADD KEY `password_resets_email_index` (`email`);

--
-- Indexes for table `pembelis`
--
ALTER TABLE `pembelis`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `pembelis_email_unique` (`email`);

--
-- Indexes for table `pemesanans`
--
ALTER TABLE `pemesanans`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `penjualans`
--
ALTER TABLE `penjualans`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `suppliers`
--
ALTER TABLE `suppliers`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `users_email_unique` (`email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `barangs`
--
ALTER TABLE `barangs`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `failed_jobs`
--
ALTER TABLE `failed_jobs`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `kategoris`
--
ALTER TABLE `kategoris`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `laporans`
--
ALTER TABLE `laporans`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `migrations`
--
ALTER TABLE `migrations`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=43;

--
-- AUTO_INCREMENT for table `pembelis`
--
ALTER TABLE `pembelis`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `pemesanans`
--
ALTER TABLE `pemesanans`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `penjualans`
--
ALTER TABLE `penjualans`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `suppliers`
--
ALTER TABLE `suppliers`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
