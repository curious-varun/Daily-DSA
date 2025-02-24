import React, { useState, useEffect } from 'react';
import { motion } from 'framer-motion';
import { Code, GitHub, Award, FileText, Brain } from 'lucide-react';
import { Button } from '@/components/ui/button';
import { Card } from '@/components/ui/card';

const platformStats = [
  { platform: "LeetCode", solved: 156, rank: "Top 5%" },
  { platform: "CodeForces", solved: 89, rating: 1420 },
  { platform: "HackerRank", solved: 45, badges: 12 }
];

export default function HeroSection() {
  const [activeFeature, setActiveFeature] = useState(0);

  const features = [
    {
      icon: <Code className="w-6 h-6" />,
      title: "Unified Stats",
      description: "Track your progress across LeetCode, CodeForces, and HackerRank in one place"
    },
    {
      icon: <Award className="w-6 h-6" />,
      title: "Practice Arena",
      description: "Solve curated problems with real-time feedback and progress tracking"
    },
    {
      icon: <Brain className="w-6 h-6" />,
      title: "AI Mentor",
      description: "Learn concepts with personalized guidance instead of copied solutions"
    },
    {
      icon: <FileText className="w-6 h-6" />,
      title: "Dev Portfolio",
      description: "Showcase your coding journey with a single, dynamic profile link"
    }
  ];

  useEffect(() => {
    const timer = setInterval(() => {
      setActiveFeature((prev) => (prev + 1) % features.length);
    }, 3000);
    return () => clearInterval(timer);
  }, []);

  return (
    <div className="relative min-h-screen bg-gradient-to-b from-gray-900 via-gray-900 to-gray-800 text-white overflow-hidden">
      {/* Background Pattern */}
      <div className="absolute inset-0 opacity-20">
        <div className="absolute inset-0 bg-[linear-gradient(to_right,#80808012_1px,transparent_1px),linear-gradient(to_bottom,#80808012_1px,transparent_1px)] bg-[size:14px_24px]" />
      </div>

      <div className="relative container mx-auto px-4 pt-20 pb-16">
        <div className="text-center max-w-4xl mx-auto mb-16">
          <motion.h1
            className="text-5xl md:text-6xl font-bold mb-6 bg-clip-text text-transparent bg-gradient-to-r from-blue-400 to-emerald-400"
            initial={{ opacity: 0, y: 20 }}
            animate={{ opacity: 1, y: 0 }}
            transition={{ duration: 0.5 }}
          >
            Your Coding Journey,
            <br />
            Unified & Enhanced
          </motion.h1>
          <motion.p
            className="text-xl text-gray-300 mb-8"
            initial={{ opacity: 0, y: 20 }}
            animate={{ opacity: 1, y: 0 }}
            transition={{ duration: 0.5, delay: 0.2 }}
          >
            Track progress, practice problems, learn with AI, and showcase your skills
            <br />
            all in one powerful platform
          </motion.p>

          <div className="flex justify-center gap-4">
            <Button size="lg" className="bg-blue-600 hover:bg-blue-700">
              Start Coding
            </Button>
            <Button size="lg" variant="outline" className="border-gray-600">
              <GitHub className="mr-2 h-5 w-5" />
              Connect GitHub
            </Button>
          </div>
        </div>

        {/* Platform Stats */}
        <div className="grid md:grid-cols-3 gap-4 mb-16">
          {platformStats.map((stat, index) => (
            <motion.div
              key={stat.platform}
              initial={{ opacity: 0, y: 20 }}
              animate={{ opacity: 1, y: 0 }}
              transition={{ duration: 0.5, delay: 0.1 * index }}
            >
              <Card className="p-6 bg-gray-800/50 border-gray-700">
                <h3 className="text-lg font-semibold mb-2">{stat.platform}</h3>
                <div className="text-3xl font-bold text-blue-400 mb-1">
                  {stat.solved}
                </div>
                <p className="text-gray-400">Problems Solved</p>
                <div className="mt-2 text-sm text-gray-300">
                  {stat.rank || `Rating: ${stat.rating}` || `Badges: ${stat.badges}`}
                </div>
              </Card>
            </motion.div>
          ))}
        </div>

        {/* Features Showcase */}
        <div className="relative h-48 mb-8">
          {features.map((feature, index) => (
            <motion.div
              key={feature.title}
              className="absolute w-full"
              initial={{ opacity: 0 }}
              animate={{
                opacity: activeFeature === index ? 1 : 0,
                x: activeFeature === index ? 0 : 20
              }}
              transition={{ duration: 0.5 }}
              style={{ display: activeFeature === index ? 'block' : 'none' }}
            >
              <div className="flex items-center justify-center space-x-4">
                <div className="p-3 bg-blue-600 rounded-lg">
                  {feature.icon}
                </div>
                <div className="text-left">
                  <h3 className="text-xl font-semibold">{feature.title}</h3>
                  <p className="text-gray-300">{feature.description}</p>
                </div>
              </div>
            </motion.div>
          ))}
        </div>
      </div>
    </div>
  );
}
