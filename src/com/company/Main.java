package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner in = new Scanner(System.in);

    public static final int DOWN = 0;
    public static final int UP = 100;

    public static void main(String[] args) {

        while (true) {
            System.out.println("1.Комбинированная очередь\n2.Обычная очередь\n3.Выход");
            switch (in.nextInt()) {
                case 1:
                    handleCombinedQueue();
                    break;
                case 2:
                    handleSimpleQueue();
                    break;
                case 3:
                    return;
                default:
                    break;
            }
        }

        /*CombinedQueue cq = new CombinedQueue();

        PriorityQueue pq = PriorityQueue.randomPriorityQueue(6);

        System.out.println("Priority queue:");
        pq.print();

        ArrayList<WeighedQueue> wqs = new ArrayList<>(4);
        wqs.add(WeighedQueue.randomWeighedQueue(0.4, 10));
        wqs.add(WeighedQueue.randomWeighedQueue(0.3, 10));
        wqs.add(WeighedQueue.randomWeighedQueue(0.2, 10));
        wqs.add(WeighedQueue.randomWeighedQueue(0.1, 10));

        System.out.println("Weighed queues:");
        for (WeighedQueue wq : wqs) {
            System.out.print("[" + wqs.indexOf(wq) + "] = ");
            wq.print();
        }

        cq.priorityQueue = pq;
        cq.weighedQueues = wqs;
        cq.size = 10;

        cq.process();
        System.out.println(cq.processed.size);
        cq.processed.priorityQueue.print();
        for (WeighedQueue wq : cq.processed.weighedQueues) {
            wq.print();
        }

        for (WeighedQueue wq : wqs) {
            System.out.print("[" + wqs.indexOf(wq) + "] = ");
            wq.print();
        }*/
    }

    static void handleCombinedQueue() {
        CombinedQueue cq = new CombinedQueue();
        System.out.println("Введите количество обрабатываемых элементов: ");
        cq.size = in.nextInt();
        System.out.println("Введите размер приоритетной очереди: ");
        cq.priorityQueue = PriorityQueue.randomPriorityQueue(in.nextInt());
        System.out.println("Введите количество взвешенных очередей: ");
        int wNum = in.nextInt();
        ArrayList<WeighedQueue> wqs = new ArrayList<>(wNum);
        double remainingRate = 1;
        for (int i = 0; i < wNum; i++) {
            System.out.println("Очередь [" + i + "] размер: ");
            int wSize = in.nextInt();
            System.out.println("Доля трафика(%): ");
            double wRate = in.nextDouble();
            remainingRate -= wRate;
            wqs.add(WeighedQueue.randomWeighedQueue(wRate, wSize));
        }
        cq.weighedQueues = wqs;
        int fSize = cq.getDataSize();
        System.out.println("--------------------------------------------------------------------");
        System.out.println("Исходная комбинированная очередь: ");
        cq.print();
        cq.process();
        System.out.println("--------------------------------------------------------------------");
        System.out.println("Комбинированная очередь после обработки: ");
        cq.print();
        System.out.println("--------------------------------------------------------------------");
        System.out.println("Обработано данных: ");
        cq.processed.print();
        //System.out.println("\nОбработано данных(%): " + cq.processed.getDataSize() / fSize * 100 + "%");
    }

    static void handleSimpleQueue() {
        WeighedQueue wq = new WeighedQueue(0);
        while (true) {
            System.out.println("1.Добавить\n2.Удалить\n3.Поиск\n4.На экран\n5.Назад\n");
            switch (in.nextInt()) {
                case 1:
                    System.out.println("Введите значение");
                    wq.insert(new Node(in.nextInt()));
                    break;
                case 2:
                    System.out.println("Полученный элемент: " + wq.extract().item);
                    break;
                case 3:
                    System.out.println("Введите значение: ");
                    Node result = wq.search(in.nextInt());
                    if (result != null)
                        System.out.println("Найдено значение: " + result.item);
                    else
                        System.out.println("Вхождений данного элемента нет!");
                    break;
                case 4:
                    wq.print();
                    break;
                case 5:
                    return;
                default:
                    break;
            }
        }
    }

}
