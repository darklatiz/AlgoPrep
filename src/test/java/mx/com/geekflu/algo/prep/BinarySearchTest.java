package mx.com.geekflu.algo.prep;

import lombok.extern.slf4j.Slf4j;
import mx.com.geekflu.algo.prep.binary.search.BinarySearch;
import mx.com.geekflu.algo.prep.binary.search.FindFirstAndLastPositionOfElementInSortedArray;
import mx.com.geekflu.algo.prep.binary.search.FindSmallestLetter;
import mx.com.geekflu.algo.prep.binary.search.FirstBadVersion;
import mx.com.geekflu.algo.prep.binary.search.PeakIndexInAMountain;
import mx.com.geekflu.algo.prep.binary.search.SearchInRotatedSortedArray;
import mx.com.geekflu.algo.prep.binary.search.SearchInsertPosition;
import mx.com.geekflu.algo.prep.binary.search.Sort3Arrays;
import mx.com.geekflu.algo.prep.util.Util;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;


@Slf4j
public class BinarySearchTest {

  @Test
  public void test_binary_search_int() {
    Integer[] array = Util.generateArray(1000, true);
    array[999] = 10001;
    int targetIndex = BinarySearch.binarySearch(array, 10001);
    Assert.assertEquals(999, targetIndex);

    targetIndex = BinarySearch.binarySearch(array, -12345);
    Assert.assertEquals(-1, targetIndex);

    Assert.assertEquals(-1, BinarySearch.binarySearch(null, 1));

    Integer[] zero = new Integer[0];
    Assert.assertEquals(-1, BinarySearch.binarySearch(zero, 1));
  }

  @Test
  public void test_binary_search_int_descending() {
    Integer[] array = new Integer[]{1000, 999, 888, 777, 666, 555, 444, 333, 222, 111, 99, 88, 77, 66, 55, 44, 33, 22, 11, 9, 8, 7};
    int targetIndex = BinarySearch.binarySearch(array, 333);
    Assert.assertEquals(7, targetIndex);
    Assert.assertEquals(0, BinarySearch.binarySearch(array, 1000));
    Assert.assertEquals(21, BinarySearch.binarySearch(array, 7));
    Assert.assertEquals(15, BinarySearch.binarySearch(array, 44));
  }

  @Test
  public void test_ceil() {
    Integer[] array = new Integer[]{2, 3, 5, 9, 14, 16, 18};
    Assert.assertEquals(5, BinarySearch.ceil(array, 15));
  }

  @Test
  public void test_floor() {
    Integer[] array = new Integer[]{2, 3, 5, 9, 14, 16, 18};
    Assert.assertEquals(4, BinarySearch.floor(array, 15));
  }

  @Test
  public void test_smallest_letters() {
    char[] chars = new char[]{'c', 'f', 'j'};
    Assert.assertEquals('c', FindSmallestLetter.findSmallestLetter(chars, 'a'));
    Assert.assertEquals('f', FindSmallestLetter.findSmallestLetter(chars, 'c'));
    Assert.assertEquals('f', FindSmallestLetter.findSmallestLetter(chars, 'd'));
    Assert.assertEquals('j', FindSmallestLetter.findSmallestLetter(chars, 'g'));
    Assert.assertEquals('c', FindSmallestLetter.findSmallestLetter(chars, 'j'));
  }

  @Test
  public void test_search_insert_position() {
    int[] nums = new int[]{1, 3 , 5, 6};
    Assert.assertEquals(2, SearchInsertPosition.searchInsert(nums, 5));
    Assert.assertEquals(1, SearchInsertPosition.searchInsert(nums, 2));
    Assert.assertEquals(4, SearchInsertPosition.searchInsert(nums, 7));
    Assert.assertEquals(0, SearchInsertPosition.searchInsert(nums, 0));
    Assert.assertEquals(0, SearchInsertPosition.searchInsert(nums, 0));
  }

  @Test
  public void test_first_bad_version() {
    int n = 10000;
    var f = new FirstBadVersion(n);
    var currentBadVersion = f.getCurrentBadVersion();
    Assert.assertEquals(currentBadVersion, f.firstBadVersion(n));

    f.changeBadVersion();
    Assert.assertEquals(f.getCurrentBadVersion(), f.firstBadVersion(n));
  }

  @Test
  public void test_find_peak_in_array() {
    int[] nums = {3,5,3,2,0};
    Assert.assertEquals(1, PeakIndexInAMountain.peakIndexInMountainArray(nums));

    int[] nums1 = {0,1,0};
    Assert.assertEquals(1, PeakIndexInAMountain.peakIndexInMountainArray(nums1));

    int[] nums2 = {0,2,1,0};
    Assert.assertEquals(1, PeakIndexInAMountain.peakIndexInMountainArray(nums2));

    int[] nums3 = {0,10,5,2};
    Assert.assertEquals(1, PeakIndexInAMountain.peakIndexInMountainArray(nums3));

    int[] nums4 = {3,4,5,1};
    Assert.assertEquals(2, PeakIndexInAMountain.peakIndexInMountainArray(nums4));

    int[] nums5 = {24,69,100,99,79,78,67,36,26,19};
    Assert.assertEquals(2, PeakIndexInAMountain.peakIndexInMountainArray(nums5));

  }

  @Test
  public void test_find_first_last_index() {
    int[] nums1 = {5,7,7,8,8,10};
    int[] expected1 = {3, 4};

    int[] nums2 = {};
    int[] expected = {-1, -1};

    Assert.assertArrayEquals(expected1, FindFirstAndLastPositionOfElementInSortedArray.searchRange(nums1, 8));
    Assert.assertArrayEquals(expected, FindFirstAndLastPositionOfElementInSortedArray.searchRange(nums1, 6));
    Assert.assertArrayEquals(expected, FindFirstAndLastPositionOfElementInSortedArray.searchRange(nums2, 0));
  }

  @Test
  public void test_find_intersection() {
    int[] arr1 = {6,16,23,37,45,54,58,60,66,87,95,102,135,136,145,146,159,161,170,171,175,178,200,208,209,211,215,217,218,227,229,238,239,276,289,295,298,313,318,324,331,333,340,344,355,357,372,373,374,376,379,390,394,395,399,413,418,419,425,431,432,436,449,458,481,484,487,489,494,501,511,515,518,524,526,528,529,534,542,544,547,552,559,564,565,571,581,589,590,595,607,618,620,641,652,663,664,669,672,680,686,694,702,713,715,729,735,746,755,769,773,774,778,780,791,793,802,804,808,810,812,816,822,827,831,841,842,850,851,861,865,877,883,891,904,907,910,912,913,915,917,934,945,958,960,971,974,976,997,999,1008,1010,1011,1015,1027,1037,1040,1045,1055,1056,1070,1090,1099,1114,1118,1122,1125,1132,1133,1141,1143,1146,1153,1159,1165,1168,1170,1172,1173,1179,1181,1184,1207,1214,1218,1219,1239,1247,1255,1267,1273,1282,1285,1295,1300,1304,1312,1326,1346,1358,1360,1362,1367,1375,1396,1397,1402,1410,1412,1416,1418,1420,1424,1425,1435,1443,1447,1464,1470,1479,1491,1502,1507,1509,1515,1520,1531,1537,1539,1556,1562,1563,1565,1577,1582,1583,1587,1589,1619,1642,1645,1648,1652,1662,1665,1677,1678,1695,1707,1711,1713,1725,1727,1731,1736,1744,1747,1751,1757,1771,1776,1783,1784,1787,1797,1802,1809,1812,1823,1827,1828,1829,1833,1836,1847,1854,1860,1867,1873,1874,1880,1887,1888,1897,1911,1913,1919,1923,1931,1948,1951,1954,1964,1965,1967,1969,1971,1973,1982,1988};
    int[] arr2 = {21,33,38,50,53,57,64,78,81,82,89,96,97,117,123,131,140,147,149,152,160,161,173,178,185,186,200,233,234,236,245,250,256,288,294,314,318,323,327,330,337,338,347,350,352,369,384,385,386,391,395,396,397,407,410,425,435,449,458,461,469,472,476,488,489,490,506,512,522,533,537,545,560,561,562,564,572,588,596,601,603,617,651,653,656,659,661,673,678,684,685,698,699,701,712,716,719,725,726,727,729,732,743,744,747,753,759,771,772,773,780,783,786,799,827,830,834,836,837,840,843,847,850,853,860,866,870,879,883,888,893,912,914,924,929,931,938,946,948,951,959,972,980,981,985,993,996,1010,1011,1014,1015,1022,1025,1029,1044,1048,1050,1053,1057,1066,1067,1070,1080,1083,1093,1095,1100,1102,1137,1151,1152,1155,1159,1170,1191,1192,1195,1211,1214,1222,1228,1229,1232,1247,1249,1256,1275,1276,1279,1280,1281,1292,1293,1306,1324,1326,1332,1348,1362,1363,1368,1386,1397,1401,1407,1408,1411,1417,1419,1421,1424,1430,1433,1443,1445,1457,1467,1471,1472,1484,1486,1488,1498,1504,1505,1521,1526,1540,1549,1550,1555,1558,1559,1563,1565,1578,1582,1584,1600,1601,1603,1612,1623,1626,1635,1640,1644,1652,1653,1654,1655,1658,1661,1669,1670,1703,1714,1726,1734,1739,1747,1749,1759,1760,1770,1796,1815,1821,1826,1838,1840,1841,1850,1853,1855,1857,1858,1859,1878,1882,1886,1888,1892,1896,1897,1899,1909,1911,1918,1920,1922,1937,1943,1953,1962,1963,1964,1980,1993,1995};
    int[] arr3 = {4,7,8,9,12,21,25,29,32,37,39,48,55,63,65,71,72,81,82,83,96,97,104,109,114,116,118,120,122,124,127,131,136,154,161,165,166,177,182,184,187,200,203,213,223,226,230,240,278,283,286,309,313,315,337,338,349,354,357,362,363,364,366,369,377,380,381,384,393,399,409,410,416,422,435,441,444,452,459,460,462,463,464,467,470,471,485,491,511,515,536,553,557,571,573,576,577,594,598,599,601,618,619,635,642,647,652,661,671,674,680,697,705,712,713,730,733,735,746,754,759,767,768,777,781,787,801,804,808,814,819,831,835,847,859,860,861,872,888,890,892,899,902,907,916,926,928,929,932,937,942,949,960,968,970,980,986,993,996,1005,1006,1007,1009,1014,1017,1026,1028,1031,1036,1041,1043,1047,1048,1054,1062,1066,1069,1072,1075,1079,1089,1090,1091,1094,1105,1111,1112,1113,1122,1139,1142,1143,1148,1157,1159,1160,1162,1163,1187,1190,1202,1219,1235,1244,1247,1249,1250,1261,1265,1279,1296,1297,1308,1309,1313,1315,1320,1323,1340,1344,1358,1370,1372,1375,1380,1415,1418,1419,1422,1432,1438,1450,1464,1466,1471,1473,1476,1479,1490,1503,1508,1511,1521,1535,1538,1541,1562,1571,1572,1576,1583,1602,1618,1620,1626,1628,1630,1647,1650,1662,1664,1665,1667,1669,1679,1686,1687,1705,1707,1742,1745,1750,1757,1784,1793,1813,1825,1826,1827,1846,1854,1863,1871,1872,1878,1886,1888,1898,1909,1913,1915,1916,1919,1932,1935,1939,1948,1970,1984,1996};
    List<Integer> expected = List.of(161,200,1159,1247,1888);
    Assert.assertEquals(expected, Sort3Arrays.arraysIntersection(arr1, arr2, arr3));
  }

  @Test
  public void test_find_smallest() {

    int[] arr00 = {3, 4, 5, 6, 0, 1, 2};
    int[] arr01 = {3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 1, 2};
    int[] arr02 = {3, 4, 5, 6, 7, 8, 9};
    int[] arr03 = {3, 1};
    int[] arr04 = {4, 5, 6, 7, 0, 1, 2};
    int[] arr05 = {1};
    int[] arr06 = {1, 3, 5};
    int[] arr07 = {17, 18, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 15};
    int[] arr08 = {3, 5, 1};


    Assert.assertEquals(4, SearchInRotatedSortedArray.findRotatedIndex(arr00));
    Assert.assertEquals(11, SearchInRotatedSortedArray.findRotatedIndex(arr01));
    Assert.assertEquals(0, SearchInRotatedSortedArray.findRotatedIndex(arr02));
    Assert.assertEquals(1, SearchInRotatedSortedArray.findRotatedIndex(arr03));
    Assert.assertEquals(4, SearchInRotatedSortedArray.findRotatedIndex(arr04));
    Assert.assertEquals(0, SearchInRotatedSortedArray.findRotatedIndex(arr05));
    Assert.assertEquals(0, SearchInRotatedSortedArray.findRotatedIndex(arr06));
    Assert.assertEquals(2, SearchInRotatedSortedArray.findRotatedIndex(arr07));

    Assert.assertEquals(-1, SearchInRotatedSortedArray.search(arr08, 0));

    Assert.assertEquals(4, SearchInRotatedSortedArray.search(arr00, 0));
    Assert.assertEquals(1, SearchInRotatedSortedArray.search(arr00, 4));
    Assert.assertEquals(2, SearchInRotatedSortedArray.search(arr00, 5));

    Assert.assertEquals(10, SearchInRotatedSortedArray.search(arr01, 13));
    Assert.assertEquals(11, SearchInRotatedSortedArray.search(arr01, 1));
    Assert.assertEquals(1, SearchInRotatedSortedArray.search(arr03, 1));
    Assert.assertEquals(0, SearchInRotatedSortedArray.search(arr05, 1));

    Assert.assertEquals(0, SearchInRotatedSortedArray.search(arr06, 1));
    Assert.assertEquals(1, SearchInRotatedSortedArray.search(arr06, 3));
    Assert.assertEquals(2, SearchInRotatedSortedArray.search(arr06, 5));




  }

}
