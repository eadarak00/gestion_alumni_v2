// src/pages/common/UnderConstruction.jsx
import React from "react";
import { Construction, ArrowLeft, Clock } from "lucide-react";
import { useNavigate } from "react-router-dom";

export const UnderConstruction = ({
    title = "Page en construction",
    description = "Cette fonctionnalité sera bientôt disponible. Revenez plus tard !",
    icon: Icon = Construction,
    estimatedDate = null
}) => {
    const navigate = useNavigate();

    return (
        <div className="min-h-[60vh] flex items-center justify-center p-6">
            <div className="max-w-md w-full text-center">
                {/* Icône animée */}
                <div className="relative mx-auto w-24 h-24 mb-8">
                    <div className="absolute inset-0 bg-gradient-to-br from-amber-400 to-orange-500 rounded-full opacity-20 animate-pulse"></div>
                    <div className="absolute inset-2 bg-gradient-to-br from-amber-100 to-orange-100 rounded-full flex items-center justify-center">
                        <Icon className="w-10 h-10 text-amber-600" />
                    </div>
                </div>

                {/* Titre */}
                <h1 className="text-2xl md:text-3xl font-bold text-gray-800 mb-4">
                    {title}
                </h1>

                {/* Description */}
                <p className="text-gray-600 mb-6 leading-relaxed">
                    {description}
                </p>

                {/* Date estimée */}
                {estimatedDate && (
                    <div className="inline-flex items-center gap-2 px-4 py-2 bg-amber-50 text-amber-700 rounded-full text-sm mb-6">
                        <Clock className="w-4 h-4" />
                        <span>Disponible : {estimatedDate}</span>
                    </div>
                )}

                {/* Barre de progression stylisée */}
                <div className="bg-gray-100 rounded-full p-1 mb-8">
                    <div className="flex items-center gap-2">
                        <div className="flex-1 h-2 bg-gradient-to-r from-amber-400 via-orange-400 to-amber-200 rounded-full relative overflow-hidden">
                            <div className="absolute inset-0 bg-gradient-to-r from-transparent via-white/40 to-transparent animate-shimmer"></div>
                        </div>
                        <span className="text-xs text-gray-500 font-medium px-2">En cours...</span>
                    </div>
                </div>

                {/* Bouton retour */}
                <button
                    onClick={() => navigate(-1)}
                    className="inline-flex items-center gap-2 px-6 py-3 bg-gray-100 hover:bg-gray-200 text-gray-700 rounded-lg font-medium transition-all hover:gap-3"
                >
                    <ArrowLeft className="w-4 h-4" />
                    Retour
                </button>
            </div>
        </div>
    );
};

// Style pour l'animation shimmer (à ajouter dans le CSS global si nécessaire)
// @keyframes shimmer {
//   0% { transform: translateX(-100%); }
//   100% { transform: translateX(100%); }
// }
// .animate-shimmer { animation: shimmer 2s infinite; }
